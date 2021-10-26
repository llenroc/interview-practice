/*
Given an array nums of n integers where n > 1,  return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].

Example:
            i
Input:  [1, 2, 3, 4]
        [1, 1, 2, 6]
    right: 1
Output: [24,12,8,6]
*/

function getProduct(nums) {
  //edge cases
  if (!nums || !nums.length) return [];
  let res = [];

  //put all left product
  let left = 1;
  for (let i = 0; i < nums.length; i++) {
    if (i > 0) left *= nums[i - 1];
    res.push(left);
  }

  // times all right product
  let right = 1;
  for (let i = nums.length - 1; i >= 0; i--) {
    if (i < nums.length - 1) right *= nums[i + 1];
    res[i] = res[i] * right;
  }

  return res;
}
