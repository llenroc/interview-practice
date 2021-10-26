/**
 * @param {number[]} prices
 * @return {number}
 */
var maxProfit = function(prices) {
  let i = 0;
  let valley = prices[0];
  let peak = prices[0];
  let max = 0;

  while (i < prices.length - 1) {
    // going downwards until hit valley
    while (i < prices.length - 1 && prices[i] >= prices[i + 1]) {
      i++;
    }
    valley = prices[i];
    // going upwards until hit peak
    while (i < prices.length - 1 && prices[i] <= prices[i + 1]) {
      i++;
    }
    peak = prices[i];
    max += peak - valley;
  }
  return max;
};

// a simpler version

/**
 * @param {number[]} prices
 * @return {number}
 */
var maxProfit = function(prices) {
  let max = 0;
  for (let i = 1; i < prices.length; i++) {
    if (prices[i] > prices[i - 1]) {
      max += prices[i] - prices[i - 1];
    }
  }
  return max;
};
