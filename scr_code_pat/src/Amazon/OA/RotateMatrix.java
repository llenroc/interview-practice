package Amazon.OA;

/**
 * Created by yizhaoyang on 7/23/17.
 */



public class RotateMatrix {

    /**
     * Call the private method to solve the problem
     * @param matrix A m * n matrix to be rotated
     * @param flag   An integer indicating the rotation direction, 1 stands for clockwise,
     *               other values stand for counter-clockwise
     * @return       A n * m matrix after the rotation operation
     */
    public int[][] solution(int[][] matrix, int flag) {
        // If the matrix is null, row number is zero, column number is zero,
        // return the given matrix directly
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return matrix;
        }

        return rotate(matrix, flag);
    }

    /**
     * Private function for encapsulation
     * Rotate the matrix by 90 degrees based on the flag value
     * @param matrix A m * n matrix to be rotated
     * @param flag   An integer indicating the rotation direction, 1 stands for clockwise,
     *               other values stand for counter-clockwise
     * @return       A n * m matrix after the rotation operation
     */
    private int[][] rotate(int[][] matrix, int flag) {
        // Get the number of rows and columns of the rotated n * m matrix
        int newCol = matrix.length;
        int newRow = matrix[0].length;

        // Create a new n * m matrix to store the rotated matrix
        int[][] rotatedMatrix = new int[newRow][newCol];

        if (flag == 1) {
            // If the flag is 1, rotate clockwise
            for (int i = 0; i < newCol; i ++) {
                for (int j = 0; j < newRow; j ++) {
                    rotatedMatrix[j][newCol - 1 - i] = matrix[i][j];
                }
            }
        } else {
            // If the flag is not 1, rotate counter-clockwise
            for (int i = 0; i < newCol; i ++) {
                for (int j = 0; j < newRow; j ++) {
                    rotatedMatrix[newRow - 1 - j][i] = matrix[i][j];
                }
            }
        }

        return rotatedMatrix;
    }

    // Main method for testing
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
                {10, 11, 12}};
        RotateMatrix rm = new RotateMatrix();
        int[][] rotatedMatrix = rm.solution(matrix, -5);
        for (int i = 0; i < rotatedMatrix.length; i ++) {
            for (int j = 0; j < rotatedMatrix[0].length; j ++) {
                System.out.print(rotatedMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * Call the private function to solve the problem
     * @param matrix A m * n matrix to be rotated
     * @param flag   A integer indicates the rotation direction, 1 stands for clockwise,
     *               other values stand for counter-clockwise
     * @return       A n * m matrix after the rotation operation
     */
    public int[][] solution_2(int[][] matrix, int flag) {
        // If the matrix has no element (is null, row number is zero,
        // column number is zero), return the given matrix directly
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return matrix;
        }

        // First transpose the given matrix
        int[][] rotatedMatrix = transposeMatrix(matrix);

        // Flip the transposed matrix based on the flag value to get the final rotated matrix
        flipMatrix(rotatedMatrix, flag);

        return rotatedMatrix;
    }

    /**
     * Private function for encapsulation, transpose a given matrix
     * @param matrix A m * n matrix to be transposed
     * @return       A n * m matrix after the transposition operation
     */
    private int[][] transposeMatrix(int[][] matrix) {
        // Get the number of the rows and columns of the given m * n matrix to be transposed
        int newCol = matrix.length;
        int newRow = matrix[0].length;

        // Create a new n * m matrix to store the transposed matrix
        int[][] transposedMatrix = new int[newRow][newCol];

        // Assign every element in the given matrix to the transposed matrix by swapping indices
        for (int i = 0; i < newCol; i ++) {
            for (int j = 0; j < newRow; j ++) {
                transposedMatrix[j][i] = matrix[i][j];
            }
        }

        return transposedMatrix;
    }

    /**
     * Private function for encapsulation, flip the transposed matrix to
     * finish the rotation operation based on the flag value
     * @param transposedMatrix A n * m transposed matrix of the original matrix
     * @param flag             A integer indicates the rotation direction, 1 stands for clockwise,
     *                         other values stand for counter-clockwise
     */
    private void flipMatrix(int[][] transposedMatrix, int flag) {
        // Get the number of the rows and columns of the transposed n * m matrix
        int row = transposedMatrix.length;
        int col = transposedMatrix[0].length;

        if (flag == 1) {
            // If flag is equal to 1, rotate matrix clockwise
            // Implemented by flipping the transposed matrix vertically
            for (int i = 0; i < row; i ++) {
                for (int j = 0; j < col / 2; j ++) {
                    int temp = transposedMatrix[i][j];
                    transposedMatrix[i][j] = transposedMatrix[i][col - j - 1];
                    transposedMatrix[i][col - j - 1] = temp;
                }
            }

        } else {
            // If flag is equal to 1, rotate the matrix counter-clockwise
            // Implemented by flipping the transposed matrix horizontally
            for (int i = 0; i < row / 2; i ++) {
                for (int j = 0; j < col; j ++) {
                    int temp = transposedMatrix[i][j];
                    transposedMatrix[i][j] = transposedMatrix[row - i - 1][j];
                    transposedMatrix[row - i - 1][j] = temp;
                }
            }
        }
    }

}
