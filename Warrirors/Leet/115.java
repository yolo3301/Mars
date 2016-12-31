public class Solution {
    public int numDistinct(String s, String t) {
        if (s.isEmpty() || t.isEmpty()) return 0;
        int slen = s.length();
        int tlen = t.length();
        int[][] dp = new int[slen+1][tlen+1];

        for (int i = 1; i <= slen; i++) {
            for (int j = 1; j <= tlen; j++) {
                dp[i][j] = dp[i-1][j];
                if (s.charAt(i-1) == t.charAt(j-1)) {
                    if (j == 1) dp[i][j] += 1;
                    else dp[i][j] += dp[i-1][j-1];
                }
            }
        }

        return dp[slen][tlen];
    }
}
