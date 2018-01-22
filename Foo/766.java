class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        int m = matrix.length;
        if (m == 0) return true;
        int n = matrix[0].length;
        if (n == 0) return true;

        for (int j = n-1; j >= 0; j--) {
            int val = matrix[0][j];
            for (int a = 0; a < m && j+a < n; a++) {
                if (matrix[a][j+a] != val) return false;
            }
        }

        for (int i = 1; i < m; i++) {
            int val = matrix[i][0];
            for (int a = 0; i+a < m && a < n; a++) {
                if (matrix[i+a][a] != val) return false;
            }
        }

        return true;
    }
}