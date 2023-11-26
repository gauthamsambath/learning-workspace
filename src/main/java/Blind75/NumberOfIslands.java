package Blind75;

public class NumberOfIslands {

    public static void main(String[] args) {
        char[][] grid = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };

        char[][] grid2 = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        NumberOfIslands numberOfIslands = new NumberOfIslands();
        System.out.println("Number of islands = "+numberOfIslands.numIslands(grid));
        System.out.println("Number of islands = "+numberOfIslands.numIslands(grid2));
    }

    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        int counter = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dp[i][j] == 0 && grid[i][j] == '1') {
                    counter++;
                    dfs(i, j, counter, dp, grid, m, n);
                }
            }
        }

        return counter;
    }

    private void dfs(int i, int j, int counter, int[][] dp, char[][] grid, int m, int n) {
        if (i < 0 || j < 0 || i >= m || j >= n || grid[i][j] == '0' || dp[i][j] == counter)
            return;

        if (grid[i][j] == '1')
            dp[i][j] = counter;

        grid[i][j] = '0';

        dfs(i + 1, j, counter, dp, grid, m, n);
        dfs(i - 1, j, counter, dp, grid, m, n);
        dfs(i, j + 1, counter, dp, grid, m, n);
        dfs(i, j - 1, counter, dp, grid, m, n);

        grid[i][j] = '1';
    }
}
