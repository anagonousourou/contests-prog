/**
 * Implement the solution in this function
 *
 * @param {number[]} nums The list of numbers.
 * @returns {string} The string representing the minimum number.
 */
function minimumNumber(nums) {
    let strings = [];
    for (let i of nums) {
        strings.push(`${i}`);
    }
    strings = strings.sort();
    return strings.join('');
}

console.log(minimumNumber([
    1,
    2,
    12,
    21,
    0
  ]))