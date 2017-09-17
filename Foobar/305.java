class Solution {
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        int[][] dirs = new int[][]{{0,1}, {0,-1}, {1,0}, {-1,0}};
        int[] root = new int[m*n];
        Arrays.fill(root, -1);

        List<Integer> res = new ArrayList<>();
        int cnt = 0;
        for (int[] pos : positions) {
            int index = pos[0]*n + pos[1];
            root[index] = index;
            cnt++;

            for (int[] d : dirs) {
                int nx = pos[0]+d[0];
                int ny = pos[1]+d[1];
                int nIdx = nx*n + ny;
                if (nx >= 0 && ny >= 0 && nx < m && ny < n && root[nIdx] != -1) {
                    int nRoot = getRoot(nIdx, root);
                    if (root[index] != nRoot) {
                        root[index] = nRoot;
                        index = nRoot;
                        cnt--;
                    }
                }
            }

            res.add(cnt);
        }

        return res;
    }

    private int getRoot(int x, int[] root) {
        while (root[x] != x) {
            root[x] = root[root[x]];
            x = root[x];
        }

        return x;
    }
}