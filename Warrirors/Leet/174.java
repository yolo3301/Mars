public class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        if (m == 0) return 0;
        int n = dungeon[0].length;
        if (n == 0) return 0;

        int[][] dp = new int[m][n];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int curr = dungeon[i][j];
                if (i == m - 1 && j == n - 1) {
                    dp[i][j] = Math.max(1, -dungeon[i][j] + 1);
                } else if (i == m - 1) {
                    dp[i][j] = Math.max(1, dp[i][j+1] - curr);
                } else if (j == n - 1) {
                    dp[i][j] = Math.max(1, dp[i+1][j] - curr);
                } else {
                    dp[i][j] = Math.max(1, Math.min(dp[i][j+1], dp[i+1][j]) - curr);
                }
            }
        }

        return dp[0][0];
    }
}
