class Solution {
    public int maxProfit(int[] prices) {
        int[][] t = new int[prices.length][2];  // [index][buy state]
        
        // Initialize memo table with -1
        for (int i = 0; i < prices.length; i++) {
            for (int j = 0; j <= 1; j++) {
                t[i][j] = -1;
            }
        }

        return helper(0, 1, prices, t);
    }

    public int helper(int ind, int buy, int[] prices, int[][] t) {
        if (ind >= prices.length) return 0;

        if (t[ind][buy] != -1) return t[ind][buy];

        int profit = 0;
        if (buy == 1) {
            // Buy or skip
            profit = Math.max(
                -prices[ind] + helper(ind + 1, 0, prices, t),  // buy
                helper(ind + 1, 1, prices, t)                  // skip
            );
        } else {
            // Sell or skip
            profit = Math.max(
                prices[ind] + helper(ind + 2, 1, prices, t),   // sell with cooldown
                helper(ind + 1, 0, prices, t)                  // skip
            );
        }

        return t[ind][buy] = profit;
    }
}
