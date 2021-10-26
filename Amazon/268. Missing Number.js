/**
 * @param {number[]} nums
 * @return {number}
 * 
 * Guass Fformula
 */
var missingNumber = function (nums) {
    let expectedSum = (nums.length * (nums.length + 1)) / 2;
    let actualSum = 0;

    for (let num of nums) {
        actualSum += num;
    }

    return expectedSum - actualSum;
};