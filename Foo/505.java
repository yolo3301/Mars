public class Solution {
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        int m = maze.length;
        if (m == 0) return 0;
        int n = maze[0].length;
        if (n == 0) return 0;

        int[][] visited = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                visited[i][j] = Integer.MAX_VALUE;
            }
        }

        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> {
            return a[0] - b[0];
        });

        queue.add(new int[]{0, start[0], start[1]});
        while (!queue.isEmpty()) {
            int[] curr = queue.remove();
            if (curr[1] == destination[0] && curr[2] == destination[1]) {
                return curr[0];
            }
            goAllDirs(maze, visited, queue, curr, m, n);
        }

        return -1;
    }

    int[][] dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};

    private void goAllDirs(int[][] maze, int[][] visited, PriorityQueue<int[]> queue, int[] curr, int m, int n) {
        for (int[] d : dirs) {
            int step = curr[0];
            int x = curr[1];
            int y = curr[2];
            while (x >= 0 && x < m && y >= 0 && y < n && maze[x][y] != 1) {
                x += d[0];
                y += d[1];
                step++;
            }
            x -= d[0];
            y -= d[1];
            step--;

            if (visited[x][y] > step) {
                visited[x][y] = step;
                queue.add(new int[]{step, x, y});
            }
        }
    }
}