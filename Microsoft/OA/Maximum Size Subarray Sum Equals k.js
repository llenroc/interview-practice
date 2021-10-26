/**
 * Given an array nums and a target value k, 
 * find the maximum length of a subarray that sums to k. If there isn't one, return 0 instead.
 */

/**
we can use a HashMap stores persum til index i as key, meaning that the sum of all elements before index i is key, and we store i as the value. 
For each i position, check not only the current sum but also we check (sum - k) which means the sum of every element up to that index from index 0 is sum - k,
 * if we find at position j, presum = sum - k, then it means sum of [j, i] equals to k
 */

/**
 * 
 * @param {number[]} nums 
 * @param {number} k 
 */
function maxLen(nums, k) {
    let maxLen = 0;
    let sum = 0;
    let map = new Map();

    for (let i = 0; i < nums.length; i++) {
        sum += nums[i];
        if (sum === k) {
            maxLen = i + 1;
        } else {
            if (map.has(sum - k)) {
                maxLen = Math.max(maxLen, i - map.get(sum - k));
            }

            if (!map.has(sum)) {
                map.set(sum, i);
            }
        }
    }

    return maxLen;
}