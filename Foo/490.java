public class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> {
            return a[2] - b[2];
        });
        q.add(new int[]{start[0], start[1], 0});

        int m = maze.length;
        int n = maze[0].length;
        int[][] visited = new int[m][n];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                visited[i][j] = Integer.MAX_VALUE;
            }
        }

        while (!q.isEmpty()) {
            int[] curr = q.remove();
            if (curr[0] == destination[0] && curr[1] == destination[1])
                return true;
            goAllDirs(curr, q, maze, visited, m, n);
        }

        return false;
    }
    int[][] dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
    private void goAllDirs(int[] curr, PriorityQueue<int[]> q, int[][] maze, int[][] visited, int m, int n) {
        for (int[] d : dirs) {
            int x = curr[0];
            int y = curr[1];
            int dist = curr[2];
            while (x >= 0 && x < m && y >= 0 && y < n && maze[x][y] != 1) {
                x += d[0];
                y += d[1];
                dist++;
            }

            x -= d[0];
            y -= d[1];
            dist--;

            if (dist < visited[x][y]) {
                visited[x][y] = dist;
                q.add(new int[]{x, y, dist});
            }
        }
    }
}