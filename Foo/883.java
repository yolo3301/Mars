class Solution {
    public int projectionArea(int[][] grid) {
        int a1 = 0, a2 = 0, a3 = 0;
        int n = grid.length;
        int[] xm = new int[n];
        int[] ym = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] > 0) {
                    a1++;
                    if (grid[i][j] > xm[i]) {
                        a2 += grid[i][j] - xm[i];
                        xm[i] = grid[i][j];
                    }
                    if (grid[i][j] > ym[j]) {
                        a3 += grid[i][j] - ym[j];
                        ym[j] = grid[i][j];
                    }
                }
            }
        }

        return a1+a2+a3;
    }
}