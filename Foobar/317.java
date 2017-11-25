class Solution {
    public int shortestDistance(int[][] grid) {
        int m = grid.length;
        if (m == 0) return 0;
        int n = grid[0].length;
        if (n == 0) return 0;

        int totalBuildings = 0;
        int[][] cnt = new int[m][n]; // needed in case of unreachable cell
        int[][] steps = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    totalBuildings++;
                    bfs(new int[]{i, j}, m, n, grid, cnt, steps);
                }
            }
        }

        int ret = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0 && cnt[i][j] == totalBuildings) {
                    ret = Math.min(ret, steps[i][j]);
                }
            }
        }

        return ret == Integer.MAX_VALUE ? -1 : ret;
    }

    private void bfs(int[] start, int m, int n, int[][] grid, int[][] cnt, int[][] steps) {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];
        q.add(start);
        visited[start[0]][start[1]] = true;
        int dist = 0;
        int[][] dirs = new int[][]{{1,0}, {-1,0}, {0,1}, {0,-1}};

        while (!q.isEmpty()) {
            dist++;
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] cur = q.remove();
                for (int[] d : dirs) {
                    int x = cur[0]+d[0];
                    int y = cur[1]+d[1];
                    if (x>=0 && y>=0 && x<m && y<n && grid[x][y] == 0 && !visited[x][y]) {
                        q.add(new int[]{x, y});
                        visited[x][y] = true;
                        cnt[x][y]++;
                        steps[x][y] += dist;
                    }
                }
            }
        }
    }
}
