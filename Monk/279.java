public class Solution {
    public int numSquares(int n) {
        int max = (int)Math.sqrt(n);
        int[] sq = new int[max+1];
        int[] dp = new int[n+1];
        dp[1] = 1;

        for (int i = 1; i <= max; i++) {
            sq[i] = i * i;
        }

        for (int i = 2; i <= n; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 1; j <= max && sq[j] <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - sq[j]] + 1);
            }
        }

        return dp[n];
    }
}