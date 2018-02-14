class Solution {
    public int swimInWater(int[][] grid) {
        int m = grid.length;
        if (m == 0) return 0;

        int[][] dirs = new int[][]{{0,-1},{-1,0},{0,1},{1,0}};

        int ret = Math.max(grid[0][0], grid[m-1][m-1]);
        Map<Integer, int[]> index = new HashMap<>();
        int[] root = new int[m*m];
        Arrays.fill(root, -1);
        int cnt = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                index.put(grid[i][j], new int[]{i, j});
                if (grid[i][j] <= ret) {
                    cnt++;
                    root[grid[i][j]] = grid[i][j];
                    int curRoot = grid[i][j];

                    for (int[] d : dirs) {
                        int x = i + d[0];
                        int y = j + d[1];
                        if (x >= 0 && y >= 0 && x < m && y < m && grid[x][y] <= ret && root[grid[x][y]] != -1) {
                            int r = findRoot(grid[x][y], root);
                            if (curRoot != r) {
                                root[curRoot] = r;
                                curRoot = r;
                                cnt--;
                            }
                        }
                    }
                }
            }
        }

        while (findRoot(grid[0][0], root) != findRoot(grid[m-1][m-1], root)) {
            int[] cur = index.get(++ret);
            int i = cur[0];
            int j = cur[1];
            cnt++;
            root[grid[i][j]] = grid[i][j];
             int curRoot = grid[i][j];

             for (int[] d : dirs) {
                 int x = i + d[0];
                 int y = j + d[1];
                 if (x >= 0 && y >= 0 && x < m && y < m && grid[x][y] <= ret && root[grid[x][y]] != -1) {
                     int r = findRoot(grid[x][y], root);
                     if (curRoot != r) {
                         root[curRoot] = r;
                         curRoot = r;
                         cnt--;
                     }
                 }
             }
        }

        return ret;
    }

    private int findRoot(int i, int[] root) {
        while (root[i] != i) {
            root[i] = root[root[i]];
            i = root[i];
        }

        return i;
    }
}