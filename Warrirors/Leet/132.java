public class Solution {
    public int minCut(String s) {
        if (s.length() < 2) return 0;

        boolean[][] isPan = new boolean[s.length()][s.length()];
        int[] dp = new int[s.length()];

        for (int i = 0; i < s.length(); i++) {
            isPan[i][i] = true;
            dp[i] = (i == 0) ? 0 : dp[i-1] + 1;
            for (int j = i - 1; j >= 0; j--) {
                if (s.charAt(i) == s.charAt(j) && (j + 1 == i || dp[j+1][i-1] == 0)) {
                    isPan[j][i] = true;

                    if (j == 0) dp[i] = 0;
                    else {
                        dp[i] = Math.min(dp[i], dp[j-1] + 1);
                    }
                }
            }
        }

        return dp[s.length() - 1];
    }
}
