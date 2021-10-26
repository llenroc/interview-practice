/**
dp[i][j] = if s[i] to s[j] palindrone

case 1: when i = j, true
case 2: when j - i = 1, if s[i] = s[j], true
case 3: when j - i > 1,
            if s[j] === s[i] & dp[i+1][j-1] = true, true
**/
var longestPalindrome = function (s) {
    if (!s) return null;
    let dp = [];
    let res = s[0];
    for (let i = s.length - 1; i >= 0; i--) {
        dp[i] = [];
        for (let j = i; j < s.length; j++) {
            if (i === j) {
                dp[i][j] = true;
            }
            if (j - i === 1 && s[i] === s[j]) {
                dp[i][j] = true;
            }
            if (j - i > 1 && s[i] === s[j] && dp[i + 1][j - 1]) {
                dp[i][j] = true;
            }
            if (dp[i][j] && (j - i + 1) > res.length) {
                res = s.slice(i, j + 1);
            }
        }
    }
    return res;
};