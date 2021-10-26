/**
 * @param {number[][]} envelopes
 * @return {number}
 */
var maxEnvelopes = function (envelopes) {
    if (envelopes == null
        || envelopes.length == 0
        || envelopes[0] == null
        || envelopes[0].length == 0) {
        return 0;
    }

    envelopes.sort((a, b) => a[0] - b[0]);

    let n = envelopes.length;
    let dp = new Array(n);

    let ret = 0;
    for (let i = 0; i < n; i++) {
        dp[i] = 1;

        for (let j = 0; j < i; j++) {
            if (envelopes[i][0] > envelopes[j][0]
                && envelopes[i][1] > envelopes[j][1]) {
                dp[i] = Math.max(dp[i], 1 + dp[j]);
            }
        }

        ret = Math.max(ret, dp[i]);
    }
    return ret;
};