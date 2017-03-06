public class Solution {
    public int getMoneyAmount(int n) {
        return helper(1, n, new int[n+1][n+1]);
    }

    public int helper(int s, int e, int[][] memo) {
        if (s >= e) return 0;
        if (memo[s][e] != 0) return memo[s][e];

        int res = Integer.MAX_VALUE;
        for (int i = s; i <= e; i++) {
            res = Math.min(res, Math.max(helper(s, i - 1, memo), helper(i + 1, e, memo)) + i);
        }

        memo[s][e] = res;
        return res;
    }
}