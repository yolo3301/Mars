public class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        int m = matrix.length;
        if (m == 0) return matrix;
        int n = matrix[0].length;
        if (n == 0) return matrix;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] != 0) {
                    int up = i == 0 ? Integer.MAX_VALUE-1 : matrix[i-1][j];
                    int left = j == 0 ? Integer.MAX_VALUE-1 : matrix[i][j-1];
                    matrix[i][j] = Math.min(Integer.MAX_VALUE-1, Math.min(up, left)+1);
                }
            }
        }

        for (int i = m-1; i >= 0; i--) {
            for (int j = n-1; j >= 0; j--) {
                if (matrix[i][j] != 0) {
                    int down = i == m-1 ? Integer.MAX_VALUE-1 : matrix[i+1][j];
                    int right = j == n-1 ? Integer.MAX_VALUE-1 : matrix[i][j+1];
                    matrix[i][j] = Math.min(matrix[i][j], Math.min(down, right)+1);
                }
            }
        }

        return matrix;
    }
}