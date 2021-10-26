/**
 * @param {number[]} A
 * @param {number} K
 * @return {number}
 *
 * https://leetcode.com/problems/subarray-sums-divisible-by-k/discuss/217962/Java-Clean-O(n)-Number-Theory-%2B-Prefix-Sums
 * https://www.youtube.com/watch?v=pkx6SowjL7M
 */
var subarraysDivByK = function(A, K) {
  if (!A || !A.length) return 0;
  let count = 0;
  let map = new Map();
  let prefixSum = 0;
  map.set(0, 1);

  for (let i = 0; i < A.length; i++) {
    prefixSum = (prefixSum + A[i]) % K;
    if (prefixSum < 0) prefixSum += K;
    let freq = map.get(prefixSum) || 0;
    count += freq;
    map.set(prefixSum, freq + 1);
  }
  return count;
};
