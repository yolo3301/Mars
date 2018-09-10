class Solution {
    public int surfaceArea(int[][] grid) {
        int m = grid.length;
        int area = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 0) continue;
                area += 2 + 4 * grid[i][j];
                if (i-1>=0) {
                    area -= 2 * Math.min(grid[i-1][j], grid[i][j]);
                }
                if (j-1>=0) {
                    area -= 2 * Math.min(grid[i][j-1], grid[i][j]);
                }
            }
        }
        return area;
    }
}