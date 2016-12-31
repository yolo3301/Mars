// https://discuss.leetcode.com/topic/60418/java-solution-using-priorityqueue/2
public class Solution {
    public int trapRainWater(int[][] heightMap) {
        int m = heightMap.length;
        if (m == 0) return 0;
        int n = heightMap[0].length;
        if (n == 0) return 0;

        PriorityQueue<int[]> queue = new PriorityQueue<>(1, new Comparator<int[]>() {
            public int compare(int[] v1, int[] v2) {
                return v1[2] - v2[2];
            }
        });
        int[][] visited = new int[m][n];

        for (int i = 0; i < n; i++) {
            queue.add(new int[] {0, i, heightMap[0][i]});
            queue.add(new int[] {m-1, i, heightMap[m-1][i]});
            visited[0][i] = true;
            visited[m-1][i] = true;
        }
        for (int i = 1; i < m - 1; i++) {
            queue.add(new int[] {i, 0, heightMap[i][0]});
            queue.add(new int[] {i, n-1, heightMap[i][n-1]});
            visited[i][0] = true;
            visited[i][n-1] = true;
        }

        int res = 0;
        int[][] dirs = new int[][] {{1,0},{-1,0},{0,1},{0,-1}};
        while (!queue.isEmpty()) {
            int[] curr = queue.remove();
            for (int[] dir : dirs) {
                int x = curr[0] + dir[0];
                int y = curr[1] + dir[1];
                if (x >= 0 && x < m && y >= 0 && y < n && !visited[x][y]) {
                    visited[x][y] = true;
                    res += Math.max(0, curr[2] - heightMap[x][y]);
                    queue.add(new int[] {x, y, Math.max(heightMap[x][y], curr[2])});
                }
            }
        }

        return res;
    }
}
