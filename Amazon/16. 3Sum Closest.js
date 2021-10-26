/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
 * 
 * O(n2)
 * O(1)
 */
var threeSumClosest = function (nums, target) {
    if (!nums || nums.length < 3) return [];

    let diff = Number.MAX_VALUE;
    nums = nums.sort((a, b) => a - b);

    for (let i = 0; i < nums.length - 2; i++) {
        let j = i + 1;
        let k = nums.length - 1;

        while (j < k) {
            let sum = nums[i] + nums[j] + nums[k];
            if (Math.abs(sum - target) < Math.abs(diff)) {
                diff = target - sum;
            }
            if (diff === 0) break;

            if (sum < target) {
                j++;
            } else {
                k--;
            }
        }
    }
    return target - diff;
};
