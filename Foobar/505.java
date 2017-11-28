class Solution {
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        int m = maze.length;
        if (m == 0) return 0;
        int n = maze[0].length;
        if (n == 0) return 0;

        int[][] visited = new int[m][n];
        for (int i = 0; i < m; i++) Arrays.fill(visited[i], Integer.MAX_VALUE);

        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> {
            return a[0] - b[0];
        });

        queue.add(new int[]{0, start[0], start[1]});
        while (!queue.isEmpty()) {
            int[] cur = queue.remove();
            if (cur[1] == destination[0] && cur[2] == destination[1])
                return cur[0];
            
            goDirs(cur, visited, maze, queue, m, n);
        }

        return -1;
    }

    int[][] dirs = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};

    private void goDirs(int[] cur, int[][] visited, int[][] maze, PriorityQueue<int[]> queue, int m, int n) {
        for (int[] d : dirs) {
            int step = cur[0];
            int x = cur[1];
            int y = cur[2];
            while ((x+d[0]) >= 0 && (x+d[0]) < m && (y+d[1]) >= 0 && (y+d[1]) < n
                && maze[x+d[0]][y+d[1]] != 1) {
                x += d[0];
                y += d[1];
                step++;
            }

            if (step < visited[x][y]) {
                visited[x][y] = step;
                queue.add(new int[]{step, x, y});
            }
        }
    }
}