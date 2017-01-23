public class Solution {

    private int res = 0;

    public int findMaxForm(String[] strs, int m, int n) {
        bt(strs, m, n, 0, 0);
        return res;
    }

    private void bt(String[] strs, int m, int n, int index, int count) {
        if (index == strs.length || m == 0 && n == 0 || count + strs.length - index < res) {
            res = Math.max(res, count);
            return;
        }

        bt(strs, m, n, index + 1, count);

        int a = 0, b = 0;
        for (char c : strs[index].toCharArray()) {
            if (c == '0') a++;
            else if (c == '1') b++;
        }

        if (a <= m && b <= n) {
            bt(strs, m - a, n - b, index + 1, count + 1);
        }
    }
}

public class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        // till the ith string, the max # of strings can be used
        // every round, depends only on last round
        int[][] dp = new int[m+1][n+1];
        for (String s : strs) {
            int a = 0, b = 0;
            for (char c : s.toCharArray()) {
                if (c == '0') a++;
                else if (c == '1') b++;
            }
            for (int i = m; i >= a; i--) {
                for (int j = n; j >= b; j--) {
                    dp[i][j] = Math.max(1 + dp[i-a][j-b], dp[i][j]);
                }
            }
        }

        return dp[m][n];
    }
}
