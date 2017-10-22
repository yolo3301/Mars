/*
M[i, j] the min delete sum for [0, i] in s1 and [0, j] in s2
M[i, j] = min{M[i-1, j]+cost[s1(i)], M[i, j-1]+cost[s2(j, M[i-1, j-1] if s1(i)==s2(j)}
*/
class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        if (s1.equals(s2)) return 0;
        int len1 = s1.length(), len2 = s2.length();
        int[][] dp = new int[len1+1][len2+1];

        for (int i = 1; i <= len1; i++)
            dp[i][0] = dp[i-1][0] + s1.charAt(i-1);

        for (int i = 1; i <= len2; i++)
            dp[0][i] = dp[0][i-1] + s2.charAt(i-1);

        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.min(
                        dp[i-1][j] + s1.charAt(i-1),
                        dp[i][j-1] + s2.charAt(j-1)
                    );
                }
            }
        }

        return dp[len1][len2];
    }
}