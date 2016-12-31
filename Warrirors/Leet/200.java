public class Solution {
    public int numIslands(char[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) return 0;
        int m = grid.length;
        int n = grid[0].length;
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    res++;
                    flood(grid, i, j, m, n);
                }
            }
        }
        return res;
    }

    private void flood(char[][] grid, int x, int y, int m, int n) {
        if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == '1') grid[x][y] = 'x';
        else return;
        flood(grid, x - 1, y, m , n);
        flood(grid, x + 1, y, m , n);
        flood(grid, x, y - 1, m , n);
        flood(grid, x, y + 1, m , n);
    }
}
