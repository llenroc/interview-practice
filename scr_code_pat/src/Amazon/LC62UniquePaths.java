package Amazon;

/**
 * Created by yizhaoyang on 9/25/17.
 */
public class LC62UniquePaths {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        //画图就知道 所有 左边 和上边都只能是1 因为 robot only move down or right
        for(int i=0; i < m; i++){
            dp[i][0] = 1;
        }
        for(int i=0; i < n; i++){
            dp[0][i] = 1;
        }


        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m - 1][n - 1];
    }
}
