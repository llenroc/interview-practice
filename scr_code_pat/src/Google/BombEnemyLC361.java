package Google;

/**
 * Created by yizhaoyang on 6/20/17.
 */
public class BombEnemyLC361 {
    public class Solution {
        // 碰到墙的话之前的都被隔开了所以要重新计算墙后面的
        // row 横线输出 所以动 col++
        public int maxKilledEnemies(char[][] grid) {
            if(grid == null || grid.length == 0 ||  grid[0].length == 0) return 0;
            int max = 0;
            int row = 0;
            int[] col = new int[grid[0].length];
            for(int i = 0; i<grid.length; i++){ // row
                for(int j = 0; j<grid[0].length;j++){ // col
                    if(grid[i][j] == 'W') continue;
                    if(j == 0 || grid[i][j-1] == 'W'){
                        row = killedEnemiesRow(grid, i, j);
                    }
                    if(i == 0 || grid[i-1][j] == 'W'){
                        col[j] = killedEnemiesCol(grid,i,j);
                    }
                    if(grid[i][j] == '0'){
                        max = (row + col[j] > max) ? row + col[j] : max;
                    }
                }

            }

            return max;
        }
        //calculate killed enemies for row i from column j
        private int killedEnemiesRow(char[][] grid, int i, int j){
            int num = 0;
            while(j <= grid[0].length-1 && grid[i][j] != 'W'){
                if(grid[i][j] == 'E') num++;
                j++;
            }
            return num;
        }
        //calculate killed enemies for column j from row i
        private int killedEnemiesCol(char[][] grid, int i, int j){
            int num = 0;
            while(i <= grid.length -1 && grid[i][j] != 'W'){
                if(grid[i][j] == 'E') num++;
                i++;
            }
            return num;
        }
    }
}
