/**
 * Implement the solution in this function
 *
 * @param {number[]} nums The list of integers.
 * @returns {boolean} True if all numbers are unique and false otherwise.
 */
function isUnique(nums) {
    let uniqs = new Set();

    for (let n of nums) {
        uniqs.add(n);
    }
    return nums.length === uniqs.size;
}
/**
 * Implement the solution in this function
 *
 * @param {number[]} nums The list of integers.
 * @returns {boolean} True if all numbers are unique and false otherwise.
 */
function isUnique2(nums){
    return new Set(nums).size == nums.length;
}