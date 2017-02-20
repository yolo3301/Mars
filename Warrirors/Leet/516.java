public class Solution {
    public int longestPalindromeSubseq(String s) {
        if (s.length() <= 1) return s.length();
        int len = s.length();
        int[][] dp = new int[len][len];

        for (int i = 0; i < len; i++)
            dp[i][i] = 1;

        for (int i = 1; i < len; i++) {
            for (int j = 0; j + i < len; j++) {
                dp[j][j+i] = Math.max(dp[j][j+i-1], dp[j+1][j+i]);
                if (s.charAt(j) == s.charAt(j+i)) {
                    dp[j][j+i] = Math.max(dp[j][j+i], dp[j+1][j+i-1]);
                }
            }
        }

        return dp[0][len-1];
    }
}