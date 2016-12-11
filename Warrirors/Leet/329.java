public class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length;
        if (m == 0) return 0;
        int n = matrix[0].length;
        if (n == 0) return 0;

        int[][] memo = new int[m][n];
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res = Math.max(res, getLongest(matrix, i, j, memo));
            }
        }

        return res;
    }

    private int getLongest(int[][] matrix, int i, int j, int[][] memo) {
        int m = matrix.length;
        int n = matrix[0].length;

        if (i < 0 || i >= m || j < 0 || j >= n) return 0;
        if (memo[i][j] != 0) return memo[i][j];

        int max = 0;
        if (i-1 >= 0 && matrix[i-1][j] > matrix[i][j])
            max = Math.max(max, getLongest(matrix, i-1, j, memo));
        if (i+1 < m && matrix[i+1][j] > matrix[i][j])
            max = Math.max(max, getLongest(matrix, i+1, j, memo));
        if (j-1 >= 0 && matrix[i][j-1] > matrix[i][j])
            max = Math.max(max, getLongest(matrix, i, j-1, memo));
        if (j+1 < n && matrix[i][j+1] > matrix[i][j])
            max = Math.max(max, getLongest(matrix, i, j+1, memo));

        memo[i][j] = max + 1;

        return memo[i][j];
    }
}
