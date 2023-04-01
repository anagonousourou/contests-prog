import ballerina/io;
import ballerina/lang.array;

// Ballerina record type definition
type FillUpEntry record {|
    int employeeId;
    int odometerReading;
    decimal gallons;
    decimal gasPrice;
|};

type AggregatedConsumption record {|
    readonly int employeeId;
    int gasFillUpCount;
    decimal totalFuelCost;
    decimal totalGallons;
    int totalMilesAccrued;
    int maxOdometerReading;
    int minOdometerReading;
|};

type AggregatedConsumptionResult record {|
    int employeeId;
    int gasFillUpCount;
    decimal totalFuelCost;
    decimal totalGallons;
    int totalMilesAccrued;
|};

function processFuelRecords(string inputFilePath, string outputFilePath) returns error? {
    json outputActual = check io:fileReadJson(inputFilePath);
    FillUpEntry[] entries = check outputActual.cloneWithType();

    table<AggregatedConsumption> key(employeeId) consumptionsIntermediate = table [];
    foreach var fillUpEntry in entries {
        if (consumptionsIntermediate.hasKey(fillUpEntry.employeeId)) {
            AggregatedConsumption consumption = consumptionsIntermediate.get(fillUpEntry.employeeId);
            consumption.gasFillUpCount += 1;
            consumption.totalFuelCost += fillUpEntry.gasPrice * fillUpEntry.gallons;
            consumption.totalGallons += fillUpEntry.gallons;
            consumption.minOdometerReading = int:min(fillUpEntry.odometerReading, consumption.minOdometerReading);
            consumption.maxOdometerReading = int:max(fillUpEntry.odometerReading, consumption.maxOdometerReading);
            consumption.totalMilesAccrued = consumption.maxOdometerReading - consumption.minOdometerReading;

        } else {
            consumptionsIntermediate.add({
                employeeId: fillUpEntry.employeeId,
                gasFillUpCount: 1,
                totalFuelCost: fillUpEntry.gasPrice * fillUpEntry.gallons,
                totalGallons: fillUpEntry.gallons,
                totalMilesAccrued: 0,
                maxOdometerReading: fillUpEntry.odometerReading,
                minOdometerReading: fillUpEntry.odometerReading
            });
        }
    }

    AggregatedConsumptionResult[] consumptionsFinal = consumptionsIntermediate.'map(consumption => {
                employeeId: consumption.employeeId,
                gasFillUpCount: consumption.gasFillUpCount,
                totalFuelCost: consumption.totalFuelCost,
                totalGallons: consumption.totalGallons,
                totalMilesAccrued: consumption.totalMilesAccrued
    }).toArray().sort(array:ASCENDING, (consumption) => consumption.employeeId);

    _ = check io:fileWriteJson(outputFilePath, consumptionsFinal.toJson());

}
