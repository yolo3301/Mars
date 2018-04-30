class Solution {
    public int largestIsland(int[][] grid) {
        int m = grid.length;
        if (m == 0) return 0;
        int n = grid[0].length;
        if (n == 0) return 0;

        List<Integer> sizes = new ArrayList<>(Arrays.asList(0, 0));
        int ret = 0;
        int replace = 2;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int cur = fill(grid, replace++, i, j);
                    sizes.add(cur);
                    ret = Math.max(ret, cur);
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    int cur = 1;
                    Set<Integer> seen = new HashSet<>();
                    if (i-1 >= 0 && !seen.contains(grid[i-1][j])) {
                        cur += sizes.get(grid[i-1][j]);
                        seen.add(grid[i-1][j]);
                    }
                    if (i+1 < m && !seen.contains(grid[i+1][j])) {
                        cur += sizes.get(grid[i+1][j]);
                        seen.add(grid[i+1][j]);
                    }
                    if (j-1 >= 0 && !seen.contains(grid[i][j-1])) {
                        cur += sizes.get(grid[i][j-1]);
                        seen.add(grid[i][j-1]);
                    }
                    if (j+1 < n && !seen.contains(grid[i][j+1])) {
                        cur += sizes.get(grid[i][j+1]);
                        seen.add(grid[i][j+1]);
                    }

                    ret = Math.max(ret, cur);
                }
            }
        }

        return ret;
    }

    private int fill(int[][] grid, int replace, int x, int y) {
        if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || grid[x][y] != 1)
            return 0;
        grid[x][y] = replace;
        int ret = 1;
        ret += fill(grid, replace, x+1, y);
        ret += fill(grid, replace, x-1, y);
        ret += fill(grid, replace, x, y-1);
        ret += fill(grid, replace, x, y+1);

        return ret;
    }
}