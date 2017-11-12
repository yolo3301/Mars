class Solution {
    public int trapRainWater(int[][] heightMap) {
        int m = heightMap.length;
        if (m == 0) return 0;
        int n = heightMap[0].length;
        if (n == 0) return 0;

        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> {
            return a[2] - b[2];
        });
        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            queue.add(new int[]{i, 0, heightMap[i][0]});
            queue.add(new int[]{i, n-1, heightMap[i][n-1]});
            visited[i][0] = true;
            visited[i][n-1] = true;
        }

        for (int j = 0; j < n; j++) {
            queue.add(new int[]{0, j, heightMap[0][j]});
            queue.add(new int[]{m-1, j, heightMap[m-1][j]});
            visited[0][j] = true;
            visited[m-1][j] = true;
        }

        int[][] dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        int ret = 0;
        while (!queue.isEmpty()) {
            int[] cur = queue.remove();
            for (int[] d : dirs) {
                int x = cur[0]+d[0];
                int y = cur[1]+d[1];
                if (x >= 0 && y >= 0 && x < m && y < n && !visited[x][y]) {
                    visited[x][y] = true;
                    // Why you can do this?
                    // Cuz we already have all the edges covered, so the water can't go out!
                    ret += Math.max(0, cur[2] - heightMap[x][y]);
                    queue.add(new int[]{x, y, Math.max(heightMap[x][y], cur[2])});
                }
            }
        }

        return ret;
    }
}