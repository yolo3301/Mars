public class Solution {
    public boolean isMatch(String s, String p) {
        if (p.isEmpty() && s.isEmpty()) return true;
        if (p.isEmpty()) return false;

        boolean[][] dp = new boolean[s.length()+1][p.length()+1];
        dp[0][0] = true;

        for (int j = 1; j <= p.length(); j++) {
            if (p.charAt(j-1) == '*')
                dp[0][j] = dp[0][j-1];
            else
                dp[0][j] = false;
        }

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= p.length(); j++) {
                char sc = s.charAt(i-1);
                char pc = p.charAt(j-1);
                if (sc == pc || pc == '?') {
                    dp[i][j] = dp[i-1][j-1];
                } else if (pc == '*') {
                    dp[i][j] = (dp[i][j-1] || dp[i-1][j]);
                }
            }
        }

        return dp[s.length()][p.length()];
    }
}
