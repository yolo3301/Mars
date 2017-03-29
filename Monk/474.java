// My naive solution
public class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        if (strs.length == 0 || (m == 0 && n == 0)) return 0;

        int[][][] dp = new int[strs.length+1][m+1][n+1];

        for (int i = 1; i <= strs.length; i++) {
            int zc = 0, oc = 0;
            for (char ch : strs[i-1].toCharArray()) {
                if (ch == '0') zc++;
                else oc++;
            }

            for (int j = m; j >= 0; j--) {
                for (int k = n; k >= 0; k--) {
                    if (j >= zc && k >= oc)
                        dp[i][j][k] = Math.max(dp[i-1][j][k], dp[i-1][j-zc][k-oc]+1);
                    else
                        dp[i][j][k] = dp[i-1][j][k];
                }
            }
        }

        return dp[strs.length][m][n];
    }
}

public class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        if (strs.length == 0 || (m == 0 && n == 0)) return 0;

        int[][] dp = new int[m+1][n+1];

        for (String s : strs) {
            int zc = 0, oc = 0;
            for (char ch : s.toCharArray()) {
                if (ch == '0') zc++;
                else oc++;
            }

            // Why need from bottom right to upper left?
            // How to use previous results?
            for (int j = m; j >= zc; j--) {
                for (int k = n; k >= oc; k--) {
                    dp[j][k] = Math.max([j][k], dp[j-zc][k-oc]+1);
                }
            }
        }

        return dp[m][n];
    }
}