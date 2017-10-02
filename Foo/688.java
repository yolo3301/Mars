class Solution {
    public double knightProbability(int N, int K, int r, int c) {
        int len = N;
        int[][] dirs = new int[][]{{1, 2}, {-1, 2}, {1, -2}, {-1, -2}, {2, 1}, {-2, 1}, {2, -1}, {-2, -1}};
        double[][] dp0 = new double[len][len];
        for (int i = 0; i < len; i++) Arrays.fill(dp0[i], 1); // starting with all in the board
        for (int a = 0; a < K; a++) {
            double[][] dp1 = new double[len][len];
            for (int i = 0; i < len; i++) {
                for (int j = 0; j < len; j++) {
                    for (int[] d : dirs) {
                        int row = i + d[0];
                        int col = j + d[1];
                        // Accumulate the count that can be reached to [i, j] in 'a' steps from all board places
                        if (row >= 0 && row < len && col >= 0 && col < len) dp1[i][j] += dp0[row][col];
                    }
                }
            }
            dp0 = dp1;
        }

        return dp0[r][c] / Math.pow(8, K);
    }
}