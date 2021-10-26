/**
 * @param {number} n
 * @return {number}
 */

// Recursion method 1, Brute Force
//O(2^n)
var climbStairs1 = function(n) {
  return climb(0, n);
};

var climb1 = function(curr, n) {
  if (curr > n) return 0;
  if (curr === n) return 1;

  return climb(curr + 1, n) + climb(curr + 2, n);
};

var climbStairs2 = function(n) {
  let arr = new Array(n).fill(0);
  return climb2(0, n);

  function climb2(curr) {
    if (curr > n) return 0;
    if (curr === n) return 1;
    if (arr[curr] > 0) return arr[curr];

    arr[curr] = climb2(curr + 1, n) + climb2(curr + 2, n);
    return arr[curr];
  }
};

// dp
var climbStairs = function(n) {
  let arr = new Array(n + 1).fill(0);

  arr[1] = 1;
  arr[2] = 2;
  for (let i = 3; i <= n; i++) {
    arr[i] = arr[i - 1] + arr[i - 2];
  }
  return arr[n];
};
