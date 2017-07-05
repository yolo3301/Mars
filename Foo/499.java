public class Solution {
    public class Point implements Comparable<Point> {
        public int x, y, step;
        public String path;
        public Point(int x, int y) {
            this(x, y, Integer.MAX_VALUE, "");
        }
        public Point(int x, int y, int step, String path) {
            this.x = x;
            this.y = y;
            this.step = step;
            this.path = path;
        }
        public int compareTo(Point other) {
            return step == other.step ? path.compareTo(other.path) : step - other.step;
        }
    }

    public String findShortestWay(int[][] maze, int[] ball, int[] hole) {
        int m = maze.length;
        if (m == 0) return "impossible";
        int n = maze[0].length;
        if (n == 0) return "impossible";

        Point[][] visited = new Point[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                visited[i][j] = new Point(i, j);
            }
        }

        PriorityQueue<Point> queue = new PriorityQueue<>();

        queue.add(new Point(ball[0], ball[1], 0, ""));
        while (!queue.isEmpty()) {
            Point curr = queue.remove();
            if (visited[curr.x][curr.y].compareTo(curr) <= 0) continue;
            visited[curr.x][curr.y] = curr;
            for (int i = 0; i < 4; i++) {
                int xx = curr.x, yy = curr.y, dd = curr.step;
                while (xx >= 0 && xx < m && yy >= 0 && yy < n && maze[xx][yy] == 0 && (xx != hole[0] || yy != hole[1])) {
                    xx += dirs[i][0];
                    yy += dirs[i][1];
                    dd++;
                }

                if (xx != hole[0] || yy != hole[1]) {
                    xx -= dirs[i][0];
                    yy -= dirs[i][1];
                    dd --;
                }

                queue.add(new Point(xx, yy, dd, curr.path + ps[i]));
            }
        }

        return visited[hole[0]][hole[1]].step == Integer.MAX_VALUE ? "impossible" : visited[hole[0]][hole[1]].path;
    }

    int[][] dirs = new int[][]{{1, 0}, {0, -1}, {0, 1}, {-1, 0}};
    String[] ps = new String[]{"d", "l", "r", "u"};
}