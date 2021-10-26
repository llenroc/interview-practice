/**
 * @param {number[]} nums
 * @return {number}
 */

/**
 *
 * [1,2,3,1]
 *  2 cases: rob first, not rob first
 *  rob first: [1, 2, 3]
 *  not: [2, 3, 1]
 */
var rob = function(nums) {
  //edge cases
  if (!nums || !nums.length) return 0;

  let first = rob(true);
  let noFirst = rob(false);
  return Math.max(first, noFirst);

  function rob(robFirst) {
    let start = robFirst ? 0 : 1;
    let end = robFirst ? nums.length - 1 : nums.length;
    let prevSum = 0;
    let currSum = 0;

    for (let i = start; i < end; i++) {
      let tmp = currSum;
      currSum = Math.max(prevSum + nums[i], currSum);
      prevSum = tmp;
    }
    return currSum;
  }
};
