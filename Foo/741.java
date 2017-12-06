class Solution {
    public int cherryPickup(int[][] grid) {
        int len = grid.length;
        if (len == 0) return 0;

        /*
          Assume 2 people walking from start to end
          r1 + c1 = r2 + c2
          Those are the steps
          So we only need 3 vars
         */

        int[][][] memo = new int[len][len][len];
        for (int[][] m1 : memo) {
            for (int[] m2 : m1) {
                Arrays.fill(m2, Integer.MIN_VALUE);
            }
        }
        M = memo;
        N = len;

        return Math.max(0, dp(grid, 0, 0, 0));
    }

    int[][][] M;
    int N;

    private int dp(int[][] grid, int r1, int c1, int c2) {
        int r2 = r1 + c1 - c2;
        if (r1 == N || c1 == N || c2 == N || r2 == N || grid[r1][c1] == -1 || grid[r2][c2] == -1)
            return -99999999;
        if (r1 == N-1 && c1 == N-1)
            return grid[r1][c1];
        if (M[r1][c1][c2] != Integer.MIN_VALUE)
            return M[r1][c1][c2];

        int ret = grid[r1][c1];
        if (c1 != c2) ret += grid[r2][c2];

        ret += Math.max(dp(grid, r1+1, c1, c2),
               Math.max(dp(grid, r1+1, c1, c2+1),
               Math.max(dp(grid, r1, c1+1, c2+1),
                        dp(grid, r1, c1+1, c2))));

        M[r1][c1][c2] = ret;
        return ret;
    }
}

