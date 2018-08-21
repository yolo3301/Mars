class Solution {
    public int[][] flipAndInvertImage(int[][] A) {
        int m = A.length;
        if (m == 0) return A;
        int n = A[0].length;
        if (n == 0) return A;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < (n+1)/2; j++) {
                swapAndInvert(A, i, j, n-1-j);
            }
        }

        return A;
    }

    private void swapAndInvert(int[][] A, int i, int x, int y) {
        int tmp = A[i][x];
        A[i][x] = A[i][y];
        A[i][y] = tmp;

        A[i][x] ^= 1;
        if (x != y) {
            A[i][y] ^= 1;
        }
    }
}