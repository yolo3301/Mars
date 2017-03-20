public class Solution {
    public int numDistinct(String s, String t) {
        int slen = s.length();
        int tlen = t.length();

        if (slen == 0 || tlen == 0) return 0;
        int[][] dp = new int[tlen+1][slen+1];

        for (int i = 1; i <= tlen; i++) {
            for (int j = 1; j <= slen; j++) {
                dp[i][j] = dp[i][j-1];                
                if (s.charAt(j-1) == t.charAt(i-1)) {
                    if (i == 1) dp[i][j]++;
                    else dp[i][j] += dp[i-1][j-1];
                }
            }
        }

        return dp[tlen][slen];
    }
}