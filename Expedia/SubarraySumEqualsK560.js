/*
    Brutal force:
    Time: O(n^3)
    Space: O(1)
*/
var subarraysDivByK1 = function(nums, k) {
  let count = 0;
  for (let i = 0; i < nums.length; i++) {
    for (let j = i + 1; j < nums.length; j++) {
      let sum = 0;
      for (let k = i; k <= j; k++) {
        sum += nums[k];
      }
      if (sum === k) count++;
    }
  }
  return count;
};

/*
    improvement on calculating part
    since for [1, 2, 3], we dont need 1, 1 + 2, 1+2+3 O(n) Operation,
    we record the prevSum nums[j-1] + curr nums[j] 
*/
var subarraysDivByK2 = function(nums, k) {
  let count = 0;
  for (let i = 0; i < nums.length; i++) {
    let prefixSum = 0;
    for (let j = i + 1; j < nums.length; j++) {
      prefixSum += nums[j];
      if (prefixSum === k) count++;
    }
  }
  return count;
};

/*
    https://www.youtube.com/watch?v=aYfwus5T3Bs
    precompute,
    for each j , we wanna count how many prefixSum[i] such that prefix[j] - k = prefix[i];
*/

var subarraysDivByK3 = function(nums, k) {
  if (!nums || !nums.length) return 0;
  let count = 0;
  let map = new Map();
  let prefixSum = 0;
  map.set(0, 1);

  for (let i = 0; i < nums.length; i++) {
    prefixSum += nums[i];
    let freq = map.get(prefixSum - k) || 0;
    count += freq;
    let val = map.get(prefixSum) ? map.get(prefixSum) + 1 : 1;
    map.set(prefixSum, val);
  }
  return count;
};
