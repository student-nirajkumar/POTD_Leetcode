class Solution {
    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {

        Collections.sort(robot);
        Arrays.sort(factory, (a, b) -> a[0] - b[0]);

        int n = robot.size();
        int m = factory.length;

        long[][] dp = new long[m + 1][n + 1];
        for (int j = 0; j < n; j++) {
            dp[m][j] = Long.MAX_VALUE / 2;
        }
        dp[m][n] = 0;
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n; j >= 0; j--) {
                dp[i][j] = dp[i + 1][j];

                long cost = 0;
                for (int k = 1; k <= factory[i][1] && j + k <= n; k++) {
                    cost += Math.abs(robot.get(j + k - 1) - factory[i][0]);

                    dp[i][j] = Math.min(dp[i][j],
                            cost + dp[i + 1][j + k]);
                }
            }
        }

        return dp[0][0];
    }
}