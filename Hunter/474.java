public class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        if (strs.length == 0) return 0;
        int[][] dp = new int[m+1][n+1];

        for (int k = 0; k < strs.length; k++) {
            int[] cnt = cnt(strs[i]);
            for (int i = m; i >= cnt[0]; i--) {
                for (int j = n; j >= cnt[1]; j--) {
                    dp[i][j] = Math.max(dp[i][j], 1 + dp[i-cnt[0]][j-cnt[1]]);
                }
            }
        }

        return dp[m][n];
    }

    private int[] cnt(String s) {
        int[] res = new int[2];
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') res[0]++;
            else res[1]++;
        }
        return res;
    }
}