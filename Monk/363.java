public class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        if (matrix.length == 0) return 0;
        if (matrix[0].length == 0) return 0;

        int m = Math.min(matrix.length, matrix[0].length);
        int n = Math.max(matrix.length, matrix[0].length);

        boolean flag = (m == matrix.length);

        int res = Integer.MIN_VALUE;
        for (int i = 0; i < m; i++) {
            int[] sums = new int[n];
            for (int j = i; j < m; j++) {
                int sum = 0;
                TreeSet<Integer> treeSet = new TreeSet<>();
                treeSet.add(0);
                for (int p = 0; p < n; p++) {
                    sums[p] += flag ? matrix[j][p] : matrix[p][j];
                    sum += sums[p];
                    Integer prev = treeSet.ceiling(sum - k);
                    if (prev != null) {
                        res = Math.max(res, sum - prev);
                    }
                    treeSet.add(sum);
                }
            }
        }

        return res;
    }
}