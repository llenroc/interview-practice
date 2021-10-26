/**
 * @param {number[]} nums
 * @return {number}
 */
var findMin = function(nums) {
  //edge cases
  if (!nums || !nums.length) return null;

  let left = 0;
  let right = nums.length - 1;
  if (nums[left] < nums[right]) return nums[0];

  while (left < right) {
    let mid = Math.floor(left + (right - left) / 2);
    if (mid > 0 && nums[mid] < nums[mid - 1]) {
      return nums[mid];
    } else if (nums[left] <= nums[mid] && nums[right] < nums[mid]) {
      left = mid + 1;
    } else {
      right = mid - 1;
    }
  }
  return nums[left];
};

//  follow up: how to handle duplicates??
