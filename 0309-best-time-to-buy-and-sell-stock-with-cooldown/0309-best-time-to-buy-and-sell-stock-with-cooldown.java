class Solution {

    public static int solve(int[] prices, int day, int n, boolean buy, int[][] dp) {
        if (day >= n) {
            return 0;
        }

        int b;
        if (buy == true) {
            b = 1;
        } else {
            b = 0;
        }

        if (dp[day][b] != -1) {
            return dp[day][b];
        }

        int profit = 0;

        if (buy) {
            int take = solve(prices, day + 1, n, false, dp) - prices[day];
            int not_take = solve(prices, day + 1, n, true, dp);
            profit = Math.max(take, not_take);
        } else {
            int sell = prices[day] + solve(prices, day + 2, n, true, dp);
            int not_sell = solve(prices, day + 1, n, false, dp);
            profit = Math.max(sell, not_sell);
        }

        dp[day][b] = profit;
        return profit;
    }

    public int maxProfit(int[] prices) {
        int n = prices.length;

        int[][] dp = new int[n][2];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        return solve(prices, 0, n, true, dp);
    }
}