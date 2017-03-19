public class Solution {
    public int trapRainWater(int[][] heightMap) {
        int m = heightMap.length;
        if (m == 0) return 0;
        int n = heightMap[0].length;
        if (n == 0) return 0;

        PriorityQueue<int[]> queue = new PriorityQueue<>((v1, v2) -> {
            return v1[2] - v2[2];
        });
        boolean[][] visited = new boolean[m][n];
        int[][] dir = new int[][]{{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
        int res = 0;

        for (int i = 0; i < m; i++) {
            queue.add(new int[]{i, 0, heightMap[i][0]});
            queue.add(new int[]{i, n-1, heightMap[i][n-1]});
            visited[i][0] = true;
            visited[i][n-1] = true;
        }

        for (int i = 1; i < n-1; i++) {
            queue.add(new int[]{0, i, heightMap[0][i]});
            queue.add(new int[]{m-1, i, heightMap[m-1][i]});
            visited[0][i] = true;
            visited[m-1][i] = true;            
        }

        while(!queue.isEmpty()) {
            int[] curr = queue.remove();
            for (int[] d : dir) {
                int x = curr[0] + d[0];
                int y = curr[1] + d[1];
                if (x >= 0 && x < m && y >= 0 && y < n && !visited[x][y]) {
                    res += Math.max(0, curr[2] - heightMap[x][y]);
                    visited[x][y] = true;
                    queue.add(new int[]{x, y, Math.max(curr[2], heightMap[x][y])});
                }
            }
        }

        return res;
    }
}