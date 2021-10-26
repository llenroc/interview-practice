function decode(str) {
  // use dp;
  // each dp meaning: ways of decoding from 0 to i - 1 position
  let dp = new Array(str.length + 1).fill(0);
  dp[0] = 1;
  dp[1] = str[0] === '0' ? 0 : 1;

  for (let i = 2; i <= str.length; i++) {
    let first = Number(str.substring(i - 1, i));
    let second = Number(str.substring(i - 2, i));

    if (first >= 1 && first <= 9) {
      dp[i] += dp[i - 1];
    }
    if (second >= 10 && second <= 26) {
      dp[i] += dp[i - 2];
    }
  }
  return dp[str.length];
}
