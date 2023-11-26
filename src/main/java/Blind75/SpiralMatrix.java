package Blind75;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

    public static void main(String[] args) {
        SpiralMatrix spiralMatrix = new SpiralMatrix();
        int[][] matrixToBeSpiralled = {{1, 2, 3, 4, 5, 6},
                {20, 21, 22, 23, 24, 7},
                {19, 32, 33, 34, 25, 8},
                {18, 31, 36, 35, 26, 9},
                {17, 30, 29, 28, 27, 10}};
        int[][] matrixToBeSpiralled2 = {{6,9,7}};
        List<Integer> spiralList = spiralMatrix.spiralOrder(matrixToBeSpiralled);
        System.out.println("Elements of the matrix in spiral order is given by = " + spiralList);
        System.out.println("Length of the list containing the elements of the matrix in spiral order is given by = " + spiralList.size());
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        int r = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int totalNumberOfElements = m * n;
        int traverseCounter = 0;
        List<Integer> spiralList = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (traverseCounter < totalNumberOfElements) {
            for (; j < n - r; j++) {
                spiralList.add(matrix[i][j]);
                traverseCounter++;
            }
            if (!traverseCounterCheck(traverseCounter, totalNumberOfElements))
                break;
            j--;
            i++;
            for (; i < m - r; i++) {
                spiralList.add(matrix[i][j]);
                traverseCounter++;
                if (!traverseCounterCheck(traverseCounter, totalNumberOfElements))
                    break;
            }
            if (!traverseCounterCheck(traverseCounter, totalNumberOfElements))
                break;
            j--;
            i--;
            for (; j >= r; j--) {
                spiralList.add(matrix[i][j]);
                traverseCounter++;
                if (!traverseCounterCheck(traverseCounter, totalNumberOfElements))
                    break;
            }
            if (!traverseCounterCheck(traverseCounter, totalNumberOfElements))
                break;
            j++;
            i--;
            for (; i > r; i--) {
                spiralList.add(matrix[i][j]);
                traverseCounter++;
                if (!traverseCounterCheck(traverseCounter, totalNumberOfElements))
                    break;
            }
            if (!traverseCounterCheck(traverseCounter, totalNumberOfElements))
                break;
            j++;
            i++;
            r++;
        }
        return spiralList;
    }

    private boolean traverseCounterCheck(int traverseCounter, int totalNumberOfElements) {
        return traverseCounter < totalNumberOfElements;
    }
}
