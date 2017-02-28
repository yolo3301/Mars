public class Solution {
    public boolean isMatch(String s, String p) {
        int slen = s.length();
        int plen = p.length();
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;

        for (int i = 1; i <= plen; i++) {
            if (p.charAt(i-1) == '*') dp[0][i] = dp[0][i-2];
        }

        for (int j = 1; j <= plen; j++) {
            for (int i = 1; i <= slen; i++) {
                if (s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '.') {
                    dp[i][j] = dp[i-1][j-1];
                } else if (p.charAt(j-1) == '*') {
                    dp[i][j] = dp[i][j-2];
                    if (p.charAt(j-2) == s.charAt(i-1) || p.charAt(j-2) == '.') {
                        dp[i][j] |= dp[i-1][j];
                    }
                }
            }
        }

        return dp[slen][plen];
    }
}