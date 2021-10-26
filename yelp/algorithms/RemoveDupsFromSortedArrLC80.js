/**
 * @param {number[]} nums
 * @return {number}
 */

/*
Given a sorted array nums, 
remove the duplicates in-place such that each element appear only once and return the new length.
*/

// Time: O(n) Space: O(1)

var removeDuplicatesI = function(nums) {
  //edge cases
  if (!nums || !nums.length) return 0;

  // two pointers,
  let end = 0;

  // traverse, swap in place, such that [0, end] are valid range, i for exploring the rest
  for (let i = 1; i < nums.length; i++) {
    if (nums[i] !== nums[end]) {
      nums[++end] = nums[i];
    }
  }
  // cut array, return len
  nums = nums.slice(0, end + 1);
  return end + 1;
};

/*
Given a sorted array nums, 
remove the duplicates in-place such that duplicates appeared at most twice and return the new length.
*/

/*
 nums = [0,0,1,1,2,3,3,3,3]
                     i
                         j
 */

var removeDuplicatesII = function(nums) {
  //edge cases
  if (!nums) return 0;
  if (nums.length <= 2) return nums.length;

  // two pointers,
  let end = 1;
  // traverse, swap in place, such that [0, end] are valid range, i for exploring the rest
  for (let i = 2; i < nums.length; i++) {
    if (nums[i] !== nums[end - 1]) {
      nums[++end] = nums[i];
    }
  }
  // cut array, return len
  nums = nums.slice(0, end + 1);
  return end + 1;
};
