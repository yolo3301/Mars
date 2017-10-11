class Solution {
    public int numDistinctIslands(int[][] grid) {
        int m = grid.length;
        if (m == 0) return 0;
        int n = grid[0].length;
        if (n == 0) return 0;

        // Set<String> cnt = new HashSet<>();
        Set<List<List<Integer>>> islands = new HashSet<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    // StringBuilder sb = new StringBuilder();
                    List<List<Integer>> island = new ArrayList<>(); // why list is better???
                    dfs(grid, i, j, i, j, island);
                    // cnt.add(sb.toString());
                    islands.add(island);
                }
            }
        }

        return islands.size();
    }
    
    int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    private void dfs(int[][] grid, int i0, int j0, int i, int j, List<List<Integer>> island) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != 1)
            return;

        grid[i][j] = -1;
        island.add(Arrays.asList(i - i0, j - j0));
        // sb.append(i-i0).append(',').append(j-j0).append(';');
        for (int[] d : dirs) {
            dfs(grid, i0, j0, i+d[0], j+d[1], island);
        }
    }
}
