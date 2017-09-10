class Solution {
    public int cutOffTree(List<List<Integer>> forest) {
        if (forest == null || forest.isEmpty()) return -1;
        int m = forest.size(), n = forest.get(0).size();

        List<int[]> trees = new ArrayList<>();
        trees.add(new int[]{-1, 0, 0});
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (forest.get(i).get(j) > 1) {
                    trees.add(new int[]{forest.get(i).get(j), i, j});
                }
            }
        }
        Collections.sort(trees, (a, b) -> {
            return a[0] - b[0];
        });

        int res = 0;
        for (int i = 1; i < trees.size(); i++) {
            int startX = trees.get(i-1)[1];
            int startY = trees.get(i-1)[2];
            int endX = trees.get(i)[1];
            int endY = trees.get(i)[2];
            int step = dist(forest, startX, startY, endX, endY, m, n);
            // System.out.println(trees.get(i-1)[0] + "->" + trees.get(i)[0] + " = " + step);
            if (step == -1) return -1;
            res += step;
        }

        return res;
    }

    int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    private int dist(List<List<Integer>> forest, int sx, int sy, int ex, int ey, int m, int n) {
        if (sx == ex && sy == ey) return 0;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{sx, sy});
        int step = 0;
        boolean[][] visited = new boolean[m][n];
        visited[sx][sy] = true;

        while (!q.isEmpty()) {
            int size = q.size();
            step++;
            for (int i = 0; i < size; i++) {
                int[] curr = q.remove();
                for (int[] d : dirs) {
                    int nx = curr[0]+d[0];
                    int ny = curr[1]+d[1];
                    if (nx >= 0 && nx < m && ny >= 0 && ny < n && !visited[nx][ny] && forest.get(nx).get(ny) > 0) {
                        if (nx == ex && ny == ey) return step;
                        q.add(new int[]{nx, ny});
                        visited[nx][ny] = true;
                    }
                }
            }
        }

        return -1;
    }
}