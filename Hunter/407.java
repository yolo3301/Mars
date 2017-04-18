public class Solution {
    public int trapRainWater(int[][] heightMap) {
        int m = heightMap.length;
        if (m <= 1) return 0;
        int n = heightMap[0].length;
        if (n <= 1) return 0;

        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> {
            return a[2] - b[2];
        });
        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            heap.add(new int[]{i, 0, heightMap[i][0]});
            heap.add(new int[]{i, n-1, heightMap[i][n-1]});
            visited[i][0] = true;
            visited[i][n-1] = true;
        }

        for (int i = 0; i < n; i++) {
            heap.add(new int[]{0, i, heightMap[0][i]});
            heap.add(new int[]{m-1, i, heightMap[m-1][i]});
            visited[0][i] = true;
            visited[m-1][i] = true;
        }

        int res = 0;
        int[][] dir = new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
        while (!heap.isEmpty()) {
            int[] curr = heap.remove();
            for (int[] d : dir) {
                int x = curr[0]+d[0];
                int y = curr[1]+d[1];
                if (x >= 0 && x < m && y >= 0 && y < n && !visited[x][y]) {
                    res += Math.max(0, curr[2] - heightMap[x][y]);
                    heap.add(new int[]{x, y, Math.max(curr[2], heightMap[x][y])});
                    visited[x][y] = true;
                }
            }
        }

        return res;
    }
}