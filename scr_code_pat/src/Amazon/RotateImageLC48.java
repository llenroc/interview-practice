package Amazon;

/**
 * Created by yizhaoyang on 7/22/17.
 */
public class RotateImageLC48 {
    public void rotate(int[][] matrix) {
        for(int i = 0; i<matrix.length; i++){
            for(int j = i; j<matrix[0].length; j++){ // 注意这里j是从开始   要不然的话会把之前的也弄乱
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for(int i = 0; i <matrix.length; i++){
            for(int j = 0; j < matrix[0].length / 2; j ++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix[0].length - 1 -j];
                matrix[i][matrix[0].length - 1 -j] = temp;

            }
        }

    }
}
