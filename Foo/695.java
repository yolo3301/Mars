class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        if (m == 0) return 0;
        int n = grid[0].length;
        if (n == 0) return 0;

        int ret = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    ret = Math.max(ret, count(grid, m, n, i, j));
                }
            }
        }

        return ret;
    }

    private int count(int[][] grid, int m, int n, int i, int j) {
        if (i < 0 || i >= m || j < 0 || j >=n || grid[i][j] != 1) return 0;
        int ret = 1;
        grid[i][j] = 2;
        ret += count(grid, m, n, i-1, j);
        ret += count(grid, m, n, i+1, j);
        ret += count(grid, m, n, i, j-1);
        ret += count(grid, m, n, i, j+1);
        return ret;
    }
}
