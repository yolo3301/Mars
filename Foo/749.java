class Solution {
    int m, n;
    int[][] dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};

    public int containVirus(int[][] grid) {
        m = grid.length;
        if (m == 0) return 0;
        n = grid[0].length;
        if (n == 0) return 0;

        int ret = 0;
        int[][] walls = new int[m*n+n][m*n+n];

        while (true) {
            Set<Integer> seen = new HashSet<>();
            List<Set<Integer>> regions = new ArrayList<>();
            List<Set<Integer>> frontiers = new ArrayList<>();

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 1 && !seen.contains(i*n+j)) {
                        Set<Integer> curRegion = new HashSet<>();
                        Set<Integer> curFrontier = new HashSet<>();
                        dfs(i, j, grid, seen, walls, curRegion, curFrontier);
                        regions.add(curRegion);
                        frontiers.add(curFrontier);
                    }
                }
            }

            if (regions.isEmpty()) break;
            int index = 0;
            for (int k = 1; k < frontiers.size(); k++) {
                if (frontiers.get(k).size() > frontiers.get(index).size()) {
                    index = k;
                }
            }

            if (frontiers.get(index).isEmpty()) break;
            
            ret += buildWall(grid, regions.get(index), frontiers.get(index), walls);
            spreadVirus(grid, frontiers, index);
        }

        return ret;
    }

    private void spreadVirus(int[][] grid, List<Set<Integer>> frontiers, int index) {
        for (int i = 0; i < frontiers.size(); i++) {
            if (i == index) continue;
            for (int f : frontiers.get(i)) {
                grid[f / n][f % n] = 1;
            }
        }
    }

    private int buildWall(int[][] grid, Set<Integer> region, Set<Integer> frontier, int[][] walls) {
        for (int r : region) {
            grid[r/n][r%n] = 2;
        }

        int ret = 0;

        for (int f : frontier) {
            int x1 = f / n;
            int y1 = f % n;
            for (int[] d : dirs) {
                int x2 = x1+d[0];
                int y2 = y1+d[1];
                if (x2 < 0 || x2 >= m || y2 < 0 || y2 >= n) continue;
                if (region.contains(x2*n+y2) && walls[x1*n+y1][x2*n+y2] == 0) {
                    walls[x1*n+y1][x2*n+y2] = 1;
                    walls[x2*n+y2][x1*n+y1] = 1;
                    ret++;
                }
            }
        }

        return ret;
    }

    private void dfs(int x, int y, int[][] grid, Set<Integer> seen, int[][] walls, Set<Integer> region, Set<Integer> frontier) {
        seen.add(x*n+y);
        region.add(x*n+y);

        for (int[] d : dirs) {
            int nx = x+d[0];
            int ny = y+d[1];
            if (nx < 0 || ny < 0 || nx >= m || ny >= n) continue;
            if (region.contains(nx*n+ny)) continue;
            if (walls[x*n+y][nx*n+ny] == 1) continue;
            if (grid[nx][ny] == 0) {
                frontier.add(nx*n+ny);
            } else {
                dfs(nx, ny, grid, seen, walls, region, frontier);
            }
        }
    }
}