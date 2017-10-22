class Solution {
    public int numDistinctIslands2(int[][] grid) {
        int m = grid.length;
        if (m == 0) return 0;
        int n = grid[0].length;
        if (n == 0) return 0;

        Set<List<List<Integer>>> set = new HashSet<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    List<List<Integer>> path = new ArrayList<>();
                    dfs(i, j, path, grid);
                    set.add(normalize(path));
                    // System.out.println(set);
                }
            }
        }

        return set.size();
    }

    private void dfs(int x, int y, List<List<Integer>> path, int[][] grid) {
        if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || grid[x][y] != 1)
            return;

        path.add(Arrays.asList(x, y));
        grid[x][y] = 2;

        dfs(x+1, y, path, grid);
        dfs(x-1, y, path, grid);
        dfs(x, y+1, path, grid);
        dfs(x, y-1, path, grid);
    }

    private List<List<Integer>> normalize(List<List<Integer>> path) {
        List<List<Integer>>[] allPath = new ArrayList[8];
        for (int i = 0; i < 8; i++) allPath[i] = new ArrayList<>();
        for (List<Integer> p : path) {
            allPath[0].add(Arrays.asList(p.get(0), p.get(1)));
            allPath[1].add(Arrays.asList(p.get(0), -p.get(1)));
            allPath[2].add(Arrays.asList(-p.get(0), p.get(1)));
            allPath[3].add(Arrays.asList(-p.get(0), -p.get(1)));
            allPath[4].add(Arrays.asList(p.get(1), p.get(0)));
            allPath[5].add(Arrays.asList(p.get(1), -p.get(0)));
            allPath[6].add(Arrays.asList(-p.get(1), p.get(0)));
            allPath[7].add(Arrays.asList(-p.get(1), -p.get(0)));
        }

        for (int i = 0; i < 8; i++) Collections.sort(allPath[i], (a, b) -> {
            if (a.get(0) != b.get(0)) return a.get(0) - b.get(0);
            return a.get(1) - b.get(1);
        });

        for (int i = 0; i < 8; i++) {
            for (int j = 1; j < allPath[i].size(); j++) {
                int nx = allPath[i].get(j).get(0) - allPath[i].get(0).get(0);
                int ny = allPath[i].get(j).get(1) - allPath[i].get(0).get(1);
                allPath[i].get(j).set(0, nx);
                allPath[i].get(j).set(1, ny);
            }
            allPath[i].get(0).set(0, 0);
            allPath[i].get(0).set(1, 0);
            
            // System.out.println(allPath[i]);
        }

        Arrays.sort(allPath, (a, b) -> {
            for (int i = 0; i < a.size(); i++) {
                if (a.get(i).get(0) != b.get(i).get(0)) return a.get(i).get(0) - b.get(i).get(0);
                if (a.get(i).get(1) != b.get(i).get(1)) return a.get(i).get(1) - b.get(i).get(1);
            }
            return 0;
        });
        return allPath[0];
    }
}

