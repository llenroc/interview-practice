/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 *
 * nums = [10, 5, 2, 6], k = 100
 *             l
 *                   r
 * prod: 60
 * count: 5
 */

/*
 * sliding window
 * Time: O(n)
 * Space: O(1)
 */
var numSubarrayProductLessThanK = function(nums, k) {
  if (!nums || !nums.length) return 0;
  if (k <= 1) return 0;

  let count = 0;
  let i = 0;
  let j = 0;
  let product = 1;

  while (j < nums.length) {
    product *= nums[j];

    while (product >= k) {
      product /= nums[i++];
    }
    count += j - i + 1;
    j++;
  }
  return count;
};
