package Karat;

import java.util.ArrayList;
import java.util.List;

public class MatrixRectangle {
    public static int[] findRectangle(int[][] matrix, int i, int j) {
        int initialI = i, initialJ = j;
        while (i < matrix.length && matrix[i][j] == 0) {
            i++;
        }
        while (j < matrix[0].length && matrix[initialI][j] == 0) {
            j++;
        }
        for (int x = initialI; x <= i; x++) {
            for (int y = initialJ; y <= j; y++) {
                matrix[x][y] = -1;
            }
        }

        return new int[] { initialI, initialJ, i, j };
    }

    public static List<int[]> findRectangles(int[][] matrix) {
        List<int[]> res = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    res.add(findRectangle(matrix, i, j));
                }
            }
        }
        return res;
    }
}