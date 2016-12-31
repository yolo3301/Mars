public class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        boolean r1 = false, c1 = false;
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) c1 = true;
        }

        for (int i = 0; i < n; i++) {
            if (matrix[0][i] == 0) r1 = true;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0)
                    matrix[i][j] = 0;
            }
        }

        if (c1) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }

        if (r1) {
            for (int i = 0; i < n; i++) {
                matrix[0][i] = 0;
            }
        }
    }
}
