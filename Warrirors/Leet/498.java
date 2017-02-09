public class Solution {
    public int[] findDiagonalOrder(int[][] matrix) {
        int m = matrix.length;
        if (m == 0) return new int[0];
        int n = matrix[0].length;
        if (n == 0) return new int[0];

        boolean flag = false;
        int[] res = new int[m * n];
        int k = 0;
        for (int i = 0; i < m + n - 1; i++) {
            if (flag) {
                int ys = Math.min(n - 1, i);
                int xs = i - ys;
                for (int j = 0; ys - j >= 0 && xs + j < m; j++) {
                    res[k++] = matrix[xs + j][ys - j];
                }
                flag = false;
            } else {
                int xs = Math.min(m - 1, i);
                int ys = i - xs;
                for (int j = 0; xs - j >= 0 && ys + j < n; j++) {
                    res[k++] = matrix[xs - j][ys + j];
                }
                flag = true;
            }
        }

        return res;
    }
}