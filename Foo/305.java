public class Solution {
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> res = new ArrayList<>();
        if (m <= 0 || n <= 0) return res;

        int[][] dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};

        int cnt = 0;
        int[] roots = new int[m*n];
        Arrays.fill(roots, -1);

        for (int[] p : positions) {
            cnt++;
            int r = n*p[0] + p[1];
            roots[r] = r;

            for (int[] d : dirs) {
                int x = p[0]+d[0];
                int y = p[1]+d[1];
                int neighbor = n*x+y;
                if (x < 0 || x >= m || y < 0 || y >= n || roots[neighbor] == -1) continue;
                int neighborRoot = findRoot(roots, neighbor);
                if (neighborRoot != r) {
                    roots[r] = neighborRoot;
                    r = neighborRoot;
                    cnt--;
                }
            }

            res.add(cnt);
        }

        return res;
    }

    private int findRoot(int[] roots, int id) {
        while (id != roots[id]) {
            roots[id] = roots[roots[id]];
            id = roots[id];
        }

        return id;
    }
}