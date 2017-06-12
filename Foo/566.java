public class Solution {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int m = nums.length;
        if (m == 0) return nums;
        int n = nums[0].length;
        if (n == 0) return nums;

        if (m * n != r * c) return nums;

        int[][] res = new int[r][c];
        int a = 0, b = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res[a][b++] = nums[i][j];
                if (b == c) {
                    b = 0;
                    a++;
                }
            }
        }

        return res;
    }
}