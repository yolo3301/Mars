class Solution {
    public boolean isMatch(String s, String p) {
        int slen = s.length();
        int plen = p.length();

        if (plen == 0) return slen == 0;

        boolean[][] dp = new boolean[slen+1][plen+1];
        dp[0][0] = true;

        for (int i = 2; i <= plen; i++) {
            dp[0][i] = (p.charAt(i-1) == '*') && dp[0][i-2];
        }

        for (int i = 1; i <= slen; i++) {
            for (int j = 1; j <= plen; j++) {
                if (s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '.') {
                    dp[i][j] |= dp[i-1][j-1];
                } else if (p.charAt(j-1) == '*') {
                    dp[i][j] = dp[i][j-2];
                    if (p.charAt(j-2) == '.' || p.charAt(j-2) == s.charAt(i-1)) {
                        dp[i][j] |= dp[i-1][j];
                    }
                }
            }
        }

        return dp[slen][plen];
    }
}