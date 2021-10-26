/**
 * @param {number[]} nums
 * @return {number}
 */
var rob = function(nums) {
  if (!nums || !nums.length) return 0;

  let prevMax = 0; //[0, ... i - 2]
  let currMax = 0; // [0, ... i - 1]

  for (let i = 0; i < nums.length; i++) {
    let tmp = currMax;
    currMax = Math.max(currMax, prevMax + nums[i]);
    prevMax = tmp;
  }
  return currMax;
};
