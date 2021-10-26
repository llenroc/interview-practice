/**
 * @param {number[]} nums
 * @return {number[][]}
 * O(n2)
 * O(1)
 */
var threeSum = function (nums) {
  if (!nums || nums.length < 3) return [];

  nums = nums.sort((a, b) => a - b);
  let result = [];

  for (let i = 0; i < nums.length - 2; i++) {
    if (nums[i] > 0) break;
    if (nums[i] === nums[i - 1]) continue;

    let j = i + 1;
    let k = nums.length - 1;
    while (j < k) {
      let sum = nums[i] + nums[j] + nums[k];
      if (sum === 0) {
        result.push([nums[i], nums[j], nums[k]]);
        j++;
        k--;

        while (j < k && nums[j] === nums[j - 1]) {
          j++;
        }
        while (j < k && nums[k] === nums[k + 1]) {
          k--;
        }
      } else if (sum > 0) {
        k--;
      } else {
        j++;
      }
    }
  }

  return result;
};
