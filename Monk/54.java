public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int m = matrix.length;
        if (m == 0) return res;
        int n = matrix[0].length;
        if (n == 0) return res;

        for (int level = 0; level <= (Math.min(m, n) - 1) / 2; level++) {
            for (int i = level; i < n - level; i++) {
                res.add(matrix[level][i]);
            }

            for (int i = level + 1; i < m - level; i++) {
                res.add(matrix[i][n - level - 1]);
            }

            for (int i = n - level - 2; i >= level && m - level - 1 > level; i--) {
                res.add(matrix[m - level - 1][i]);
            }

            for (int i = m - level - 2; i > level && level < n - level - 1; i--) {
                res.add(matrix[i][level]);
            }
        }

        return res;
    }
}