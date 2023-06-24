// A record type that represents a roman numeral and its value
type Numeral record {
    readonly int value;
    string numeral;
};

# Convert an integer to a Roman number.
#
# + n - the integer to convert
# + cumul - intermediate results
# + return - the Roman number as a string
function roman(int n, string cumul = "") returns string {
    // A mapping of roman numerals and their values
    // A table of Numeral records with value as the key
    table<Numeral> key(value) numerals = table [
        {value: 1000, numeral: "M"},
        {value: 900, numeral: "CM"},
        {value: 500, numeral: "D"},
        {value: 400, numeral: "CD"},
        {value: 100, numeral: "C"},
        {value: 90, numeral: "XC"},
        {value: 50, numeral: "L"},
        {value: 40, numeral: "XL"},
        {value: 10, numeral: "X"},
        {value: 9, numeral: "IX"},
        {value: 5, numeral: "V"},
        {value: 4, numeral: "IV"},
        {value: 1, numeral: "I"}
    ];
    // A list of values in descending order
    int[] values = [1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1];
    // Base case
    if (n == 0) {
        return cumul;
    }
    // Loop through the values
    foreach int value in values {
        // If n is greater than or equal to the value
        if (n >= value) {
            // Append the corresponding numeral to the cumul string
            // Recursively call the function with the reduced n
            return roman(n - value, cumul + numerals.get(value).numeral);
        }
    }
    // This should never happen
    return "";
}
