public class Solution {
    public int maxVacationDays(int[][] flights, int[][] days) {
        int n = flights.length;
        int k = days[0].length;
        // omit optimize
        int[][] dp = new int[k+1][n];
        Arrays.fill(dp[0], Integer.MIN_VALUE);
        dp[0][0] = 0;
        int res = 0;

        for (int i = 1; i <= k; i++) {
            // init to all MIN so that for all those unreachable paths, the value will < 0
            Arrays.fill(dp[i], Integer.MIN_VALUE);
            for (int j = 0; j < n; j++) {
                for (int z = 0; z < n; z++) {
                    // z==j means stay in the same city
                    if (z == j || flights[z][j] == 1) {
                        dp[i][j] = Math.max(dp[i][j], dp[i-1][z] + days[j][i-1]);
                        res = Math.max(res, dp[i][j]);
                    }
                }
            }
        }

        return res;
    }
}