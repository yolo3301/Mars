public class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length < 2) return 0;
        int rest = 0, buy = Integer.MIN_VALUE, sell = 0;
        for (int i = 0; i < prices.length; i++) {
            int prevBuy = buy;
            int prevSell = sell;
            int prevRest = rest;
            buy = Math.max(prevBuy, rest - prices[i]);
            sell = Math.max(prevBuy + prices[i], sell);
            rest = Math.max(prevBuy, Math.max(prevSell, prevRest));
        }

        return sell;
    }
}