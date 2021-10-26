var twoSum = function (nums, target) {
    if (!nums) return [];
    // {diff, i}
    let map = new Map();
    let result = [];

    for (let i = 0; i < nums.length; i++) {
        if (map.has(nums[i])) {
            let prev = map.get(nums[i]);
            result = [prev, i];
            break;
        } else {
            let diff = target - nums[i];
            map.set(diff, i);
        }
    }

    return result;
};