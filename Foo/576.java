public class Solution {
    public int findPaths(int m, int n, int N, int i, int j) {
        dfs(i, j, 0, m, n, N);
        return res;
    }

    int mod = 1000000007;
    int res = 0;

    private void dfs(int x, int y, int step, int m, int n, int max) {
        if (step > max) return;
        if (x < 0 || x >= m || y < 0 || y >= n) {
            res++;
            if (res >= mod) res %= mod;
            return;
        }

        dfs(x-1, y, step+1, m, n, max);
        dfs(x+1, y, step+1, m, n, max);
        dfs(x, y-1, step+1, m, n, max);
        dfs(x, y+1, step+1, m, n, max);
    }
}

public class Solution {
    public int findPaths(int m, int n, int N, int i, int j) {
        if (N <= 0) return 0;

        final int MOD = 1000000007;
        int[][] cnt = new int[m][n];
        cnt[i][j] = 1;
        int res = 0;

        int[][] dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};

        for (int step = 0; step < N; step++) {
            int[][] temp = new int[m][n];
            for (int r = 0; r < m; r++) {
                for (int c = 0; c < n; c++) {
                    for (int[] d : dirs) {
                        int nr = r + d[0];
                        int nc = c + d[1];
                        if (nr < 0 || nr >= m || nc < 0 || nc >= n) {
                            res = (res + cnt[r][c]) % MOD;
                        } else {
                            temp[nr][nc] = (temp[nr][nc] + cnt[r][c]) % MOD;
                        }
                    }
                }
            }
        }

        return res;
    }
}