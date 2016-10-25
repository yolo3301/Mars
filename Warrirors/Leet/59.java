public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int k = 1;
        for (int i = 0; i <= (n - 1) / 2; i++) {
            for (int j = i; j < n - i; j++) {
                res[i][j] = k++;
            }
            for (int j = i + 1; j < n - i; j++) {
                res[j][n - 1 - i] = k++;
            }
            for (int j = n - i - 2; j >= i; j--) {
                res[n - 1 - i][j] = k++;
            }
            for (int j = n - i - 2; j > i; j--) {
                res[j][i] = k++;
            }
        }
        return res;
    }
}
