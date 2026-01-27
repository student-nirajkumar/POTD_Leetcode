class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int curr = Integer.MAX_VALUE;
        for(int i=0; i<prices.length; i++){
            curr = Math.min(curr, prices[i]);
            maxProfit = Math.max(maxProfit, prices[i] - curr);

        }
        return maxProfit;
    }
}