package Blind75;

/**
 * The type Unique ways.
 */
public class UniqueWays {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        int row = 3;
        int column = 7;
        UniqueWays uniqueWays = new UniqueWays();
        System.out.println("The number of ways the robot can reach the destination is = " + uniqueWays.uniquePaths(row, column));
        System.out.println("The number of ways the robot can reach the destination is based on chatGPT O(1) solution is = " + uniqueWays.uniquePaths2(row, column));
    }

    /**
     * Unique paths int.
     *
     * @param m the m
     * @param n the n
     * @return the int
     */
    public int uniquePaths(int m, int n) {
        int[][] robotMovingMatrix = new int[m][n];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i == m - 1 && j == n - 1)
                    robotMovingMatrix[i][j] = 1;
                else {
                    if (i + 1 < m)
                        robotMovingMatrix[i][j] += robotMovingMatrix[i + 1][j];
                    if (j + 1 < n)
                        robotMovingMatrix[i][j] += robotMovingMatrix[i][j + 1];
                }
            }
        }
        return robotMovingMatrix[0][0];
    }


    /**
     * Unique paths 2 int.
     *
     * @param m the m
     * @param n the n
     * @return the int
     * <p>
     * chatGPT solution
     */
    public int uniquePaths2(int m, int n) {
        int[] dp = new int[n];

        // Initialize the last row with 1, as there is only one possible path to reach the last column
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
        }

        // Traverse the remaining rows, updating the array with the unique path counts
        for (int row = m - 2; row >= 0; row--) {
            int right = 0; // Number of unique paths from the cell to the right

            for (int col = n - 1; col >= 0; col--) {
                // Update the current cell with the sum of the path counts from the cell below and the cell to the right
                dp[col] = dp[col] + right;

                // Update the number of unique paths from the cell to the right for the next iteration
                right = dp[col];
            }
        }

        // The value in dp[0] will contain the total unique paths to reach the destination cell
        return dp[0];
    }
}
