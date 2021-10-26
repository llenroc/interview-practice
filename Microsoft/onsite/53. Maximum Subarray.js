
var maxSubArray = function (nums) {
    if (nums == null || nums.length === 0) return 0;
    if (nums.length === 1) return nums[0];
    let prevMax = nums[0];
    let max = nums[0];
    for (let i = 1; i < nums.length; i++) {
        let currMax = Math.max(nums[i], nums[i] + prevMax);
        max = Math.max(max, currMax);
        prevMax = currMax;
    }
    return max;
};