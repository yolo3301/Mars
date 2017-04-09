public class Solution {
    public int numSquares(int n) {
        return helper(n, new int[n+1]);
    }

    private int helper(int n, int[] memo) {
        if (memo[n] != 0) return memo[n];
        if (n == 0) return 0;
        if (n == 1) return 1;

        int cnt = Integer.MAX_VALUE;
        int max = (int)Math.sqrt(n);
        for (int j = max; j > 0; j--) {
            cnt = Math.min(cnt, 1 + helper(n - j*j, memo));
        }

        memo[n] = cnt;
        return cnt;
    }
}