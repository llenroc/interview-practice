function getLongest(a, b) {
    let m = a.length;
    let n = b.length;

    let dp = new Array(m + 1);
    for (var i = 0; i < dp.length; i++) {
        dp[i] = new Array(n + 1).fill(0);
    }

    let max = '';
    for (let i = 1; i <= m; i++) {
        for (let j = 1; j <= n; j++) {
            if (a[i - 1] === b[j - 1]) {
                dp[i][j] = dp[i - 1][j - 1] + 1;
                if (dp[i][j] > max.length) {
                    max = a.substring(i - dp[i][j], i);
                }
            }
        }
    }

    return max;
}