class Solution {
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> ret = new ArrayList<>();
        int cnt = 0;
        int[] root = new int[m*n];

        Arrays.fill(root, -1);

        int[][] dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};

        for (int[] pos : positions) {
            int x = pos[0], y = pos[1];
            int k = x * n + y;
            root[k] = k;
            cnt++;

            for (int[] d : dirs) {
                int nx = x+d[0], ny = y+d[1];
                if (nx >= 0 && nx < m && ny >= 0 && ny < n && root[nx * n + ny] != -1) {
                    int r = getRoot(root, nx * n + ny);
                    if (r != root[k]) {
                        root[k] = r;
                        k = r;
                        cnt--;
                    }
                }
            }
            
            ret.add(cnt);
        }

        return ret;
    }

    private int getRoot(int[] root, int k) {
        while (root[k] != k) {
            root[k] = root[root[k]];
            k = root[k];
        }

        return k;
    }
}

