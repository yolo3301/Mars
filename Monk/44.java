public class Solution {
    public boolean isMatch(String s, String p) {
        int slen = s.length();
        int plen = p.length();
        if (slen == 0) return plen == 0;
        if (plen == 0) return false;

        boolean[][] dp = new boolean[slen+1][plen+1];
        dp[0][0] = true;

        for (int i = 1; i <= plen; i++) {
            if (p.charAt(i-1) == '*') {
                dp[0][i] = dp[0][i-1];
            } else {
                dp[0][i] = false;
            }
        }

        for (int i = 1; i <= slen; i++) {
            for (int j = 1; j <= plen; j++) {
                char sc = s.charAt(i-1);
                char pc = p.charAt(j-1);
                if (pc == sc || pc == '?') {
                    dp[i][j] = dp[i-1][j-1];
                } else if (pc == '*') {
                    dp[i][j] = dp[i-1][j] || dp[i][j-1];
                }
            }
        }

        return dp[slen][plen];
    }
}