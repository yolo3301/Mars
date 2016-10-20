public class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length <= 1) return 0;
        // can remove extra space
        // no sell on day i
        int[] ns = new int[prices.length];
        // sell on day i
        int[] s = new int[prices.length];

        for (int i = 1; i < prices.length; i++) {
            // no sell on day i is easy to understand
            ns[i] = Math.max(s[i - 1], ns[i - 1]);
            // sell on day i has 2 cases:
            // 1. sell on day i - 1, and buy on day i - 1
            // more like the sell only happened on day i (not i - 1)
            // 2. buy on day i and sell on day i
            s[i] = Math.max(s[i - 1] + prices[i] - prices[i - 1], ns[i - 1]);
            // my original solution
            /* for (int j = 0; j < i; j++) {
                int prev = 0;
                if (j - 1 >= 0) prev = ns[j - 1];
                s[i] = Math.max(s[i], Math.max(0, prices[i] - prices[j]) + prev);
            } */
        }

        return Math.max(s[prices.length - 1], ns[prices.length - 1]);
    }
}
