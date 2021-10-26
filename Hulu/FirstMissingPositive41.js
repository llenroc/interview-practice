/**
 * @param {number[]} nums
 * @return {number}
 *
 * 1, if extra space allow, we store arr[num - 1] = 1, arr[0, 0, 0], first arr[i] = 0, i + 1 first missing positive
 * 2, with constant space, nums, [3, 2, 4], overide issue
 * 3, take care of neg val, swap all neg value to the end, look at first positive part of list
 */
var firstMissingPositive = function(nums) {
  //edge cases
  if (nums == null || nums.length == 0) return null;

  // 0 to k, positive portaion
  let k = findPositive();

  for (let i = 0; i < k; i++) {
    let index = Math.abs(nums[i]) - 1;
    if (index < k) {
      let tmp = nums[index];
      nums[index] = tmp > 0 ? -tmp : tmp;
    }
  }

  for (let i = 0; i < k; i++) {
    if (nums[i] > 0) {
      return i + 1;
    }
  }
  return k + 1;

  function findPositive() {
    let index = 0;
    let end = nums.length;
    for (let i = 0; i < end; i++) {
      if (nums[i] > 0) {
        swap(i, index);
        index++;
      }
    }
    return index;
  }

  function swap(i, j) {
    let tmp = nums[i];
    nums[i] = nums[j];
    nums[j] = tmp;
  }
};

const test = [3, 4, -1, 1, 8];
console.log(firstMissingPositive(test));
