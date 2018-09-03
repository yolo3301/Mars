class Solution {
    public int[][] transpose(int[][] A) {
        int m = A.length;
        if (m == 0) return A;
        int n = A[0].length;
        if (n == 0) return A;
        int[][] ret = new int[n][m];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ret[j][i] = A[i][j];
            }
        }

        return ret;
    }
}