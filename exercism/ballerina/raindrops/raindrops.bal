# Convert a number into a string that contains raindrop sounds
#
# + n - an integer
# + return - raindrops
public function convert(int n) returns string {
    // Create a string array to store the raindrops
    string[] raindrops = [];
    // Append "Pling" to the array if n is divisible by 3
    if n % 3 == 0 {
        raindrops.push("Pling");
    }
    // Append "Plang" to the array if n is divisible by 5
    if n % 5 == 0 {
        raindrops.push("Plang");
    }
    // Append "Plong" to the array if n is divisible by 7
    if n % 7 == 0 {
        raindrops.push("Plong");
    }
    // Join the array elements with an empty separator
    string raindropString = string:'join("", ...raindrops) ;
    // Return the raindrop string if it is not empty, otherwise return n as a string
    return raindropString.length() != 0 ? raindropString : n.toString();
}
