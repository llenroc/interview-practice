/**
Given an array of n positive integers and a positive integer s, 
find the minimal length of a contiguous subarray of which the sum ≥ s. 
If there isn't one, return 0 instead.

 * @param {number} s
 * @param {number[]} nums
 * @return {number}


 Input: s = 7, nums = [2,3,1,1,4,3]
Output: 2

[2,3,1,1,4,3]
         i
           j
 sum:
 min:

Time: O(n) <= O(2n) j and i both traverse thru n
Space: O(1)
 */
var minSubArrayLen = function(s, nums) {
  let i = 0;
  let j = 0;
  let sum = 0;
  let min = Number.MAX_SAFE_INTEGER;

  while (j < nums.length) {
    sum += nums[j++];

    while (sum >= s) {
      min = Math.min(min, j - i);
      sum -= nums[i++];
    }
  }
  return min === Number.MAX_SAFE_INTEGER ? 0 : min;
};

/*
 new version: sum = s 
 
 [2,3,1,1,4,3]  7
          i
          j
 min: 4
 start:0
 end:3
 sum = 0

*/

var minSubArrayLen1 = function(s, nums) {
  let i = 0;
  let j = 0;
  let sum = 0;
  let min = Number.MAX_SAFE_INTEGER;

  while (j < nums.length) {
    sum += nums[j++];

    if (sum === s) {
      //   min = Math.min(min, j - i);
      if (j - i < min) {
        min = j - i;
        sum = 0;
        i = j;
      }
    }
  }
  return min === Number.MAX_SAFE_INTEGER ? 0 : min;
};

const testArr = [2, 3, 1, 1, 4, 3];
console.log(minSubArrayLen1(7, testArr));
