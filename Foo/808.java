class Solution {
    public double soupServings(int N) {
        if (N >= 4800) return 1.0;
        double[][] dp = new double[N+1][N+1];
        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= N; j++) {
                if (i == 0 && j == 0) dp[i][j] = 0.5;
                else if (i == 0) dp[i][j] = 1.0;
                else if (j == 0) dp[i][j] = 0.0;
                else {
                    dp[i][j] += dp[Math.max(0, i-100)][j];
                    dp[i][j] += dp[Math.max(0, i-25)][Math.max(0, j-75)];
                    dp[i][j] += dp[Math.max(0, i-50)][Math.max(0, j-50)];
                    dp[i][j] += dp[Math.max(0, i-75)][Math.max(0, j-25)];
                    
                    dp[i][j] /= 4;
                }
            }
        }

        return dp[N][N];
    }
}

/*
A - x
B - y

[x, y] = [a, b, c] a finishes, b finishes, a & b finish
 */