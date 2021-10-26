function getLargest(nums) {
    let max = 0;

    let set = new Set();
    for (let i = 0; i < nums.length; i++) {
        set.add(-nums[i]);
        if (set.has(nums[i])) {
            max = Math.max(max, Math.abs(nums[i]));
        }
    }

    return max;
}