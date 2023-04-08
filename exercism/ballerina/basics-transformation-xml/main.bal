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
    xmlns "http://www.so2w.org" as s;
    xml|io:Error xmlContent = io:fileReadXml(inputFilePath);
    if (xmlContent is xml) {
        FillUpEntry[] typedEntries = from var fuelEvent in xmlContent/<s:FuelEvent>
            select {
                employeeId: check int:fromString(fuelEvent?.employeeId ?: "0"),
                odometerReading: check int:fromString((fuelEvent/<s:odometerReading>).data()),
                gallons: check decimal:fromString((fuelEvent/<s:gallons>).data()),
                gasPrice: check decimal:fromString((fuelEvent/<s:gasPrice>).data())
            };
        AggregatedConsumptionResult[] consumptionsFinal = check processFuelRecordsInternal(typedEntries);
        // ignore unused variable
        io:Error? result = io:fileWriteXml(outputFilePath, employeeFuelRecordToXml(consumptionsFinal));
    }
}

function employeeFuelRecordToXml(AggregatedConsumptionResult[] consumptionsFinal) returns xml {

    xml:Element fuelRecordsXml = xml `<s:employeeFuelRecords xmlns:s="http://www.so2w.org"></s:employeeFuelRecords>`;
    //declare the namespace so it can be used by the template literal
    xmlns "http://www.so2w.org" as s;
    foreach var {employeeId, gasFillUpCount, totalFuelCost, totalGallons, totalMilesAccrued} in consumptionsFinal {
        xml fuelRecordXml = xml `<s:employeeFuelRecord employeeId="${employeeId}"><s:gasFillUpCount>${gasFillUpCount}</s:gasFillUpCount><s:totalFuelCost>${totalFuelCost}</s:totalFuelCost><s:totalGallons>${totalGallons}</s:totalGallons><s:totalMilesAccrued>${totalMilesAccrued}</s:totalMilesAccrued></s:employeeFuelRecord>`;
        xml:setChildren(fuelRecordsXml, xml:getChildren(fuelRecordsXml) + fuelRecordXml);

    }
    return fuelRecordsXml;
}

function processFuelRecordsInternal(FillUpEntry[] entries) returns AggregatedConsumptionResult[]|error {

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

    return consumptionsIntermediate.'map(consumption => {
        employeeId: consumption.employeeId,
        gasFillUpCount: consumption.gasFillUpCount,
        totalFuelCost: consumption.totalFuelCost,
        totalGallons: consumption.totalGallons,
        totalMilesAccrued: consumption.totalMilesAccrued
    }).toArray().sort(array:ASCENDING, (consumption) => consumption.employeeId);
}
