// profit(i ,j) means the max profit until j price and used at most i transactions
// profit(i ,j) = max(profit(i, j - 1), max (prices[j] - prices[k] + profit(i-1, k)))
// means, no transaction on j price vs transaction on j price
// reference: https://discuss.leetcode.com/topic/4766/a-clean-dp-solution-which-generalizes-to-k-transactions
public class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length < 2) return 0;

        int k = 2;
        int res = 0;
        int[][] profit = new int[k+1][prices.length];
        for (int i = 1; i <= k; i++) {
            int tmpMax = profit[i-1][0] - prices[0];
            for (int j = 1; j < prices.length; j++) {
                profit[i][j] = Math.max(profit[i][j-1], prices[j] + tmpMax);
                tmpMax = Math.max(tmpMax, profit[i-1][j] - prices[j]);
                res = Math.max(res, profit[i][j]);
            }
        }

        return res;
    }
}
