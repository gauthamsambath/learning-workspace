package Blind75;

import java.util.Arrays;

/**
 * The type Rotate matrix.
 */
public class RotateMatrix {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        RotateMatrix rotateMatrix = new RotateMatrix();
        System.out.println("Matrix before rotation = " + Arrays.deepToString(matrix));
        rotateMatrix.rotate(matrix);
        System.out.println("Rotated matrix by 90 degrees is given by = " + Arrays.deepToString(matrix));
    }

    /**
     * Rotate.
     *
     * @param matrix the matrix
     */
    public void rotate(int[][] matrix) {
        int m = matrix.length;
        for (int i = 0; i < m; i++) {
            for (int j = i + 1; j < m; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for (int i = 0; i < m / 2; i++) {
            for (int j = 0; j < m; j++) {
                int lastColumnIndex = (m - 1) - i;
                int temp = matrix[j][i];
                matrix[j][i] = matrix[j][lastColumnIndex];
                matrix[j][lastColumnIndex] = temp;
            }
        }
    }


}
