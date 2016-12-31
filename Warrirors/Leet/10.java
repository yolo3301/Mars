// https://discuss.leetcode.com/topic/40371/easy-dp-java-solution-with-detailed-explanation
// although I have some logic more concise.
public class Solution {
    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length()+1][p.length()+1];
        dp[0][0] = true;

        for (int i = 1; i <= p.length(); i++) {
            // init dp[0][x] & dp[x][0]
            // because when p has nothing, it's always false, so no need to assign
            dp[0][i] = (p.charAt(i-1) == '*' && dp[0][i-2]);
        }

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= p.length(); j++) {
                if (s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '.') {
                    dp[i][j] = dp[i-1][j-1];  // case 1: matching
                } else if (p.charAt(j-1) == '*') {
                    dp[i][j] = dp[i][j-2];  // case 2: * but no matching
                    if (p.charAt(j-2) == s.charAt(i-1) || p.charAt(j-2) == '.')
                        dp[i][j] |= dp[i-1][j];  // case 3: * and match multiple
                }
            }
        }

        return dp[s.length()][p.length()];
    }
}
