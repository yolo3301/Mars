public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        if (m == 0) return 0;
        int n = obstacleGrid[0].length;
        if (n == 0) return 0;

        int[][] helper = new int[m][n];
        helper[0][0] = 1;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    helper[i][j] = 0;
                } else {
                    if (i - 1 >= 0) {
                        helper[i][j] += helper[i-1][j];
                    }
                    if (j - 1 >= 0) {
                        helper[i][j] += helper[i][j-1];
                    }
                }
            }
        }

        return helper[m-1][n-1];
    }
} 
