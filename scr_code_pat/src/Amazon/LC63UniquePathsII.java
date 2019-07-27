package Amazon;

/**
 * Created by yizhaoyang on 9/25/17.
 */
public class LC63UniquePathsII {






    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        // 障碍在重点的话 根本到不了
        if(obstacleGrid[m - 1][n - 1] == 1) return 0;
        int[][] dp = new int[m][n];
        //画图就知道 所有 左边 和上边都只能是1 因为 robot only move down or right
        for(int i=0; i < m; i++){
            //如果碰到 障碍 接不下去 所以 0
            if(obstacleGrid[i][0] == 1) break;
            dp[i][0] = 1;
        }
        for(int i=0; i < n; i++){
            if(obstacleGrid[0][i] == 1) break;
            dp[0][i] = 1;
        }

        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                int left = obstacleGrid[i-1][j] == 1? 0:dp[i-1][j];
                int top = obstacleGrid[i][j-1] == 1? 0:dp[i][j-1];
                dp[i][j] = left + top;
            }
        }
        return dp[m - 1][n - 1];
    }

    /*
 let's take out the obstacles for now, let's go to #62, when you solve it by 2 dimension dp, let's say you have with a 4x3 array, you start like

0 0 0 0
0 0 0 0
0 0 0 0

and then you go row by row or column by column adding what's not already solved, let's choose row by row, first row will be all 1s, like

1 1 1 1
0 0 0 0
0 0 0 0

then you start the second row and you add the count of paths on the top and the count in the left, so the evolution will look like

1 1 1 1
1 0 0 0
0 0 0 0

1 1 1 1
1 2 0 0
0 0 0 0

1 1 1 1
1 2 3 0
0 0 0 0

1 1 1 1
1 2 3 4
0 0 0 0

now let's go to the third row, it's the same, I'll put the example here, but note that for the 3rd row, you only care about the second row, line 1 is too old already

1 1 1 1
1 2 3 4
1 0 0 0

1 1 1 1
1 2 3 4
1 3 0 0

1 1 1 1
1 2 3 4
1 3 6 0

1 1 1 1
1 2 3 4
1 3 6 10

The same will happen with any row, you just care about the previous one, the rest are forgotten, so you don't need to store them.
What about columns? it's the same, when you are in any column, you only care about the previous one IN THE SAME ROW, so it's ok to modify your only stored row, as, again, you don't care about older columns even in the previous row.

Now, about #63, it's exactly the same, the only difference is that when you arriba to a cell that has an obstacle, you say "I can't reach this cell, then it's a 0".
When the next cell to the right get's calculated, she (yes, cells are girls for me, spanish speaker here) will realize that her left neighbor is 0, then the only way of getting to her is form the top. The same happens with the cell at the bottom of an obstacle.

Hope this helps

     */
    // On space
    public int uniquePathsWithObstacles2(int[][] obstacleGrid) {
        int width = obstacleGrid[0].length;
        int[] dp = new int[width];
        dp[0] = 1;
        for (int[] row : obstacleGrid) {
            for (int j = 0; j < width; j++) {
                if (row[j] == 1)
                    dp[j] = 0;
                else if (j > 0)
                    dp[j] += dp[j - 1];
            }
        }
        return dp[width - 1];
    }

}
