package Amazon;

import java.util.Arrays;

/**
 * Created by yizhaoyang on 7/29/17.
 */
public class MaximumLengthPairChain {
    public int findLongestChain(int[][] pairs) {

        /*

        subproblem: dp(pair(a,b)) is dp(pair(a,b)上一层) + 1;

         */
        Arrays.sort(pairs, (a, b) -> (a[0] - b[0]));


        int i, j, max = 0, n = pairs.length;
        int dp[] = new int[n];

        for (i = 0; i < n; i++) dp[i] = 1;

        for (i = 1; i < n; i++)
            for (j = 0; j < i; j++)
                if (pairs[i][0] > pairs[j][1] && dp[i] < dp[j] + 1) // dp[i] < dp[j] + 1 取max值
                    dp[i] = dp[j] + 1;

        for (i = 0; i < n; i++) if (max < dp[i]) max = dp[i];

        return max;
    }

}
