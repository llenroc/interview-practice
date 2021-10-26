/**
 * @param {number[]} nums
 * @return {number}
 */
var lengthOfLIS = function (nums) {
    if (!nums) return null;

    // LIS til ith element, including ith element
    let dp = new Array(nums.length).fill(0);
    let answer = 1;
    // dp[i]: the len of LIS possible up to ith element
    dp[0] = 1;

    for (let i = 1; i < nums.length; i++) {
        let currMax = 0;
        // find all prior values whose value < nums[i], and we pick the one w the most LIS
        for (let j = 0; j < i; j++) {
            if (nums[j] < nums[i]) currMax = Math.max(currMax, dp[j]);
        }
        dp[i] = currMax + 1;
        answer = Math.max(answer, dp[i]);
    }

    return answer;
};