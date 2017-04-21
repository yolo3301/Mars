public class Solution {
    public int removeBoxes(int[] boxes) {
        if (boxes.length == 0) return 0;
        int n = boxes.length;
        int[][][] memo = new int[n][n][n+1];
        return dp(boxes, 0, n-1, 1, memo);
    }

    private int dp(int[] boxes, int i, int j, int k, int[][][] memo) {
        if (i > j) return 0;
        if (i == j) return k*k;
        if (memo[i][j][k] != 0) return memo[i][j][k];

        int k1 = k;
        memo[i][j][k] = k1*k1 + dp(boxes, i+1, j, 1, memo);
        for (int z = i+1; z <= j; z++) {
            if (boxes[z] == boxes[i]) {
                memo[i][j][k] = Math.max(memo[i][j][k], dp(boxes, i+1, z-1, 1, memo)+dp(boxes, z, j, k1+1, memo));
            }
        }

        return memo[i][j][k];
    }
}