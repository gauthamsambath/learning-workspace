package Blind75;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * The type Pacific atlantic water flow.
 */
public class PacificAtlanticWaterFlow {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        int[][] heights = {{1, 2, 2, 3, 5}, {3, 2, 3, 4, 4}, {2, 4, 5, 3, 1}, {6, 7, 1, 4, 5}, {5, 1, 1, 2, 4}};
        PacificAtlanticWaterFlow pacificAtlanticWaterFlow = new PacificAtlanticWaterFlow();
        System.out.println("List of all the co-ordinates where water flows to Paific and atlantic are = " + pacificAtlanticWaterFlow.pacificAtlantic(heights));
    }

    /**
     * Pacific atlantic list.
     *
     * @param heights the heights
     * @return the list
     */
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        CanReachSea[][] dp = new CanReachSea[m][n];
        Arrays.setAll(dp, i -> {
            CanReachSea[] row = new CanReachSea[n];
            Arrays.setAll(row, j -> new CanReachSea());
            return row;
        });
        boolean[][] visited = new boolean[m][n];
        List<List<Integer>> finalList = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                CanReachSea temp = dp[i][j];
                if (!temp.isPacific() || !temp.isAtlantic()) {
                    temp = dfs(i, j, m, n, dp, visited, heights, heights[i][j] + 1);
                }
                if (temp.isPacific() && temp.isAtlantic()) {
                    List<Integer> tempList = new ArrayList<>();
                    tempList.add(i);
                    tempList.add(j);
                    finalList.add(tempList);
                }
            }
        }
        return finalList;
    }

    /**
     * Dfs can reach sea.
     *
     * @param i              the
     * @param j              the j
     * @param m              the m
     * @param n              the n
     * @param dp             the dp
     * @param visited        the visited
     * @param heights        the heights
     * @param previousHeight the previous height
     * @return the can reach sea
     */
    private CanReachSea dfs(int i, int j, int m, int n, CanReachSea[][] dp, boolean[][] visited, int[][] heights, int previousHeight) {
        if (i < 0 || j < 0) {
            CanReachSea canReachSea = new CanReachSea();
            canReachSea.setPacific(true);
            return canReachSea;
        }

        if (i > m - 1 || j > n - 1) {
            CanReachSea canReachSea = new CanReachSea();
            canReachSea.setAtlantic(true);
            return canReachSea;
        }

        if (heights[i][j] > previousHeight || visited[i][j]) {
            return new CanReachSea();
        }


        visited[i][j] = true;

        CanReachSea canReachSea1;

        boolean isAtlantic = false;
        boolean isPacific = false;

        canReachSea1 = dfs(i + 1, j, m, n, dp, visited, heights, heights[i][j]);

        isAtlantic = isAtlantic || canReachSea1.isAtlantic();
        isPacific = isPacific || canReachSea1.isPacific();

        if (isAtlantic && isPacific) {
            canReachSea1.setAtlantic(true);
            canReachSea1.setPacific(true);
            visited[i][j] = false;
            return canReachSea1;
        }

        canReachSea1 = dfs(i - 1, j, m, n, dp, visited, heights, heights[i][j]);

        isAtlantic = isAtlantic || canReachSea1.isAtlantic();
        isPacific = isPacific || canReachSea1.isPacific();

        if (isAtlantic && isPacific) {
            canReachSea1.setAtlantic(true);
            canReachSea1.setPacific(true);
            visited[i][j] = false;
            return canReachSea1;
        }

        canReachSea1 = dfs(i, j + 1, m, n, dp, visited, heights, heights[i][j]);

        isAtlantic = isAtlantic || canReachSea1.isAtlantic();
        isPacific = isPacific || canReachSea1.isPacific();

        if (isAtlantic && isPacific) {
            canReachSea1.setAtlantic(true);
            canReachSea1.setPacific(true);
            visited[i][j] = false;
            return canReachSea1;
        }

        canReachSea1 = dfs(i, j - 1, m, n, dp, visited, heights, heights[i][j]);
        isAtlantic = isAtlantic || canReachSea1.isAtlantic();
        isPacific = isPacific || canReachSea1.isPacific();

        if (isAtlantic && isPacific) {
            canReachSea1.setAtlantic(true);
            canReachSea1.setPacific(true);
            visited[i][j] = false;
            return canReachSea1;
        }

        canReachSea1.setAtlantic(isAtlantic);
        canReachSea1.setPacific(isPacific);
        visited[i][j] = false;

        return canReachSea1;
    }


    /**
     * The type Can reach sea.
     */
    static class CanReachSea {
        /**
         * The Pacific.
         */
        boolean pacific;
        /**
         * The Atlantic.
         */
        boolean atlantic;

        /**
         * Instantiates a new Can reach sea.
         */
        public CanReachSea() {
            pacific = false;
            atlantic = false;
        }

        /**
         * Is pacific boolean.
         *
         * @return the boolean
         */
        public boolean isPacific() {
            return pacific;
        }

        /**
         * Sets pacific.
         *
         * @param pacific the pacific
         */
        public void setPacific(boolean pacific) {
            this.pacific = pacific;
        }

        /**
         * Is atlantic boolean.
         *
         * @return the boolean
         */
        public boolean isAtlantic() {
            return atlantic;
        }

        /**
         * Sets atlantic.
         *
         * @param atlantic the atlantic
         */
        public void setAtlantic(boolean atlantic) {
            this.atlantic = atlantic;
        }
    }
}
