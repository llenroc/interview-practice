// 3 solutions n^2 nlongn n

// n^2
function twoSum1(nums, target) {
  for (let i = 0; i < nums.length; i++) {
    let compliment = target - nums[i];
    let index = nums.indexOf(compliment, i);

    if (index !== -1) {
      return [i, index];
    }
  }
  return [0, 0];
}

// O(n*Longn)
function twoSum2(nums, target) {
  let map = new Map();

  for (let i = 0; i < nums.length; i++) {
    map.set(nums[i], i);
  }

  // O(n)
  for (let j = 0; j < nums.length; j++) {
    let compliment = target - nums[j];
    let index = map.get(compliment); // O(logn) worst case

    if (index != null && index !== j) return [j, index];
  }
  return [0, 0];
}

// O(n)
function twoSum3(nums, target) {
  let map = new Map();

  for (let i = 0; i < nums.length; i++) {
    if (map.has(nums[i])) {
      let index = map.get(nums[i]);
      return [index, i];
    }
    map.set(target - nums[i], i);
  }
  return [0, 0];
}
