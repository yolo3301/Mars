public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int m = matrix.length;
        if (m == 0) return res;
        int n = matrix[0].length;
        if (n == 0) return res;

        for (int i = 0; i <= (Math.min(m, n) - 1) / 2; i++) {
            for (int j = i; j < n - i; j++) res.add(matrix[i][j]);
            for (int j = i + 1; j < m - i; j++) res.add(matrix[j][n - i - 1]);
            // corner cases
            for (int j = n - i - 2; j >= i && m - i - 1 > i; j--) res.add(matrix[m - i - 1][j]);
            for (int j = m - i - 2; j > i && i < n - i - 1; j--) res.add(matrix[j][i]);
        }

        return res;
    }
}
