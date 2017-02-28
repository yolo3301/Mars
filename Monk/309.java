public class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length < 2) return 0;
        int[] s = new int[prices.length];
        int[] ns = new int[prices.length];

        for (int i = 1; i < prices.length; i++) {
            ns[i] = Math.max(s[i-1], ns[i-1]);
            s[i] = Math.max(ns[i-1], s[i-1] + prices[i] - prices[i-1]);

            /*for (int j = 0; j < i; j++) {
                s[i] = Math.max(s[i], s[j] + prices[i] - prices[j]);
            }*/
        }

        return Math.max(s[prices.length-1], ns[prices.length-1]);
    }
}