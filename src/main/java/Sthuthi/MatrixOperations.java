package Sthuthi;

public class MatrixOperations {

    public static void main(String[] args) {
        int[][] matrixToBeSpiralled = {{1, 2, 3, 4},
                {5, 6, 7, 8},
                {9,10,11,12},
                {13,14,15,16},
                {17,18,19,20}};

        printSumOfEachRows(matrixToBeSpiralled);
    }

    private static void printSumOfEachRows(int[][] matrixToBeSpiralled) {
        int row = matrixToBeSpiralled.length;
        int column = matrixToBeSpiralled[0].length;
        for (int i = 0; i < row; i++) {
            int sum = 0;
            for (int j = 0; j < column; j++) {
                sum+=matrixToBeSpiralled[i][j];
            }
            System.out.println("Sum of row "+i+" = "+sum);
        }
    }


}
