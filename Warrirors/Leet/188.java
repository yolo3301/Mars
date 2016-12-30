public class Solution {
    public int maxProfit(int k, int[] prices) {
        if (k == 0 || prices.length < 2) return 0;

        if (prices.length <= k) {
            return max(prices);
        }

        int[][] dp = new int[k+1][prices.length];

        int res = 0;
        for (int i = 1; i <= k; i++) {
            int tmpMax = dp[i-1][0] - prices[0];
            for (int j = 1; j < prices.length; j++) {
                dp[i][j] = Math.max(dp[i][j-1], prices[j] + tmpMax);
                tmpMax = Math.max(tmpMax, dp[i-1][j] - prices[j]);
                res = Math.max(res, dp[i][j]);
            }
        }

        return res;
    }

    private int max(int[] prices) {
        int res = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i-1]) {
                res += prices[i] - prices[i-1];
            }
        }
        return res;
    }
}
