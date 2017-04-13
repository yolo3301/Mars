public class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int m = matrix.length;
        if (m == 0) return 0;
        int n = matrix[0].length;
        if (n == 0) return 0;
        boolean flip = false;
        if (m > n) {
            flip = true;
            m = matrix[0].length;
            n = matrix.length;
        }

        int res = Integer.MIN_VALUE;
        for (int i = 0; i < m; i++) {
            int[] sum = new int[n];
            for (int j = i; j < m; j++) {
                TreeSet<Integer> set = new TreeSet<>();
                set.add(0);
                int acc = 0;
                // S2 - S1 <= k => S1 >= S2 - k
                for (int z = 0; z < n; z++) {
                    sum[z] += flip ? matrix[z][j] : matrix[j][z];
                    acc += sum[z];
                    Integer prev = set.ceiling(acc - k);
                    if (prev != null) {
                        res = Math.max(res, acc - prev);
                    }
                    set.add(acc);
                }
            }
        }

        return res;
    }
}