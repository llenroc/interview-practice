/**
 * @param {number[]} coins
 * @param {number} amount
 * @return {number}
 *
 * M: amount
 * N: num of coins
 * Time: O(M*N)
 * Space: O(M)
 */
var coinChange = function(coins, amount) {
  if (coins == null || coins.length == 0 || amount <= 0) {
    return 0;
  }
  let dp = new Array(amount + 1);
  dp[0] = 0;

  for (let i = 1; i <= amount; i++) {
    dp[i] = Number.MAX_SAFE_INTEGER;
    for (let j = 0; j < coins.length; j++) {
      if (coins[j] <= i && dp[i - coins[j]] !== Number.MAX_SAFE_INTEGER) {
        dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
      }
    }
  }
  return dp[amount] !== Number.MAX_SAFE_INTEGER ? dp[amount] : -1;
};
