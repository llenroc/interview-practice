package Microsoft;

public class SetMatrixZeroesLC73 {


        /*
        // fr = first row
    // fc = first col
    // 要用 第一排和行做标记 所以 先设一个 如果出现了 0 说明之后也要除掉
    // Use first row and first column as markers.
    // if matrix[i][j] = 0, mark respected row and col marker = 0; indicating
       that later this respective row and col must be marked 0;
    // And because you are altering first row and column,
       you need to  have two variables to track their own status.
    // So, for ex, if any one of the first row is 0, fr = 0,
       and at the end set all first row to 0;

    */
    public void setZeroes(int[][] matrix) {

        // 第一row和col是来做标记的
        boolean rm = false, cm = false;
        for(int i = 0; i < matrix.length; i++){
            for(int j =0; j < matrix[0].length; j++){
                if(matrix[i][j] == 0){
                    if(i == 0) rm = true;
                    if(j == 0) cm = true;
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;

                }
            }
        }
        // 从 i= 1， j = 1开始
        for(int i = 1; i < matrix.length; i++){
            for(int j =1; j < matrix[0].length; j++){
                if(matrix[0][j] == 0 || matrix[i][0] == 0){
                    matrix[i][j] = 0;
                }
            }
        }

        if(rm){
            for(int i = 0; i < matrix[0].length; i++){
                matrix[0][i] = 0;
            }
        }

        if(cm){
            for(int i = 0 ;  i < matrix.length; i++){
                matrix[i][0] = 0;
            }
        }
    }
}
