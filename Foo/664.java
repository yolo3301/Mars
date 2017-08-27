class Solution {
    public int strangePrinter(String s) {
        int len = s.length();
        if (len == 0) return 0;

        int[][] dp = new int[101][101];
        for (int i = 0; i < len; i++) dp[i][i] = 1;

        for (int i = 2; i <= len; i++) {
            for (int j = 0; j + i <= len; j++) {
                dp[j][j+i-1] = i;
                for (int k = j+1; k <= j+i-1; k++) {
                    int tmp = dp[j][k-1] + dp[k][j+i-1];
                    if (s.charAt(k-1) == s.charAt(j+i-1)) tmp--;
                    dp[j][j+i-1] = Math.min(dp[j][j+i-1], tmp);
                }
            }
        }

        return dp[0][len-1];
    }
}