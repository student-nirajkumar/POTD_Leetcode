class Solution {
    public int maxPathScore(int[][] grid, int k) {

        int m = grid.length;
        int n = grid[0].length;

        int[][][] dp = new int[m][n][k + 1];

        // initialize dp with -1
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int c = 0; c <= k; c++) {
                    dp[i][j][c] = -1;
                }
            }
        }

        // fill dp from bottom-right to top-left
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {

                for (int cost = 0; cost <= k; cost++) {

                    int add = 0;

                    // normal if-else (no ternary)
                    if (grid[i][j] > 0) {
                        add = 1;
                    } else {
                        add = 0;
                    }

                    int newCost = cost + add;

                    // skip invalid cost
                    if (newCost > k) {
                        continue;
                    }

                    // base case (last cell)
                    if (i == m - 1 && j == n - 1) {
                        dp[i][j][cost] = grid[i][j];
                        continue;
                    }

                    int down = -1;
                    int right = -1;

                    if (i + 1 < m) {
                        down = dp[i + 1][j][newCost];
                    }

                    if (j + 1 < n) {
                        right = dp[i][j + 1][newCost];
                    }

                    int bestNext = -1;

                    if (down != -1 && right != -1) {
                        bestNext = Math.max(down, right);
                    } else if (down != -1) {
                        bestNext = down;
                    } else if (right != -1) {
                        bestNext = right;
                    }

                    if (bestNext != -1) {
                        dp[i][j][cost] = grid[i][j] + bestNext;
                    }
                }
            }
        }

        return dp[0][0][0];
    }
}