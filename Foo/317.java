public class Solution {
    public int shortestDistance(int[][] grid) {
        int m = grid.length;
        if (m == 0) return 0;
        int n = grid[0].length;
        if (n == 0) return 0;

        int[][] dist = new int[m][n];
        int[][] cnt = new int[m][n];
        int numOfHouses = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    bfs(new int[]{i, j}, grid, dist, cnt, numOfHouses);
                    numOfHouses++;
                }
            }
        }

        int res = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0 && cnt[i][j] == numOfHouses) {
                    res = Math.min(res, dist[i][j]);
                }
            }
        }

        if (res == Integer.MAX_VALUE) return -1;
        return res;
    }

    private void bfs(int[] start, int[][] grid, int[][] dist, int[][] cnt, int init) {
        int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        // System.out.println("Start " + start[0] + " " + start[1]);
        Queue<int[]> queue = new LinkedList<>();
        queue.add(start);
        int step = 0;
        while (!queue.isEmpty()) {
            step++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] curr = queue.remove();
                for (int[] d : dirs) {
                    int x = curr[0]+d[0];
                    int y = curr[1]+d[1];
                    // System.out.println("Processing " + x + " " + y);
                    if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length
                        && grid[x][y] == 0 && cnt[x][y] == init) {
                        cnt[x][y]++;
                        dist[x][y] += step;
                        queue.add(new int[]{x, y});
                        // System.out.println("Adding " + x + " " + y);
                    }
                }
            }
        }
    }
}