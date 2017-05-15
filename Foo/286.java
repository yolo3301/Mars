public class Solution {
    public void wallsAndGates(int[][] rooms) {
        int m = rooms.length;
        if (m == 0) return;
        int n = rooms[0].length;
        if (n == 0) return;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rooms[i][j] == 0) {
                    queue.add(new int[]{i, j});
                }
            }
        }

        int[][] dirs = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        int dist = 0;
        while (!queue.isEmpty()) {
            dist++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] curr = queue.remove();
                for (int[] d : dirs) {
                    int x = curr[0] + d[0];
                    int y = curr[1] + d[1];
                    if (x >= 0 && x < m && y >= 0 && y < n && rooms[x][y] == Integer.MAX_VALUE) {
                        rooms[x][y] = dist;
                        queue.add(new int[]{x, y});
                    }
                }
            }
        }
    }
}