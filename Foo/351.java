public class Solution {
    public int numberOfPatterns(int m, int n) {
        int skip[][] = new int[10][10];
        skip[1][3] = skip[3][1] = 2;
        skip[1][7] = skip[7][1] = 4;
        skip[3][9] = skip[9][3] = 6;
        skip[7][9] = skip[9][7] = 8;
        skip[1][9] = skip[9][1] = skip[2][8] = skip[8][2] = skip[3][7] = skip[7][3] = skip[4][6] = skip[6][4] = 5;
        boolean vis[] = new boolean[10];
        int res = 0;
        for (int i = m; i <= n; i++) {
            res += dfs(vis, 1, skip, i-1) * 4;
            res += dfs(vis, 2, skip, i-1) * 4;
            res += dfs(vis, 5, skip, i-1);
        }

        return res;
    }

    private int dfs(boolean[] vis, int curr, int[][] skip, int remain) {
        if (remain < 0) return 0;
        if (remain == 0) return 1;
        vis[curr] = true;
        int res = 0;
        for (int i = 1; i <= 9; i++) {
            if (!vis[i] && (skip[curr][i] == 0 || vis[skip[curr][i]])) {
                res += dfs(vis, i, skip, remain-1);
            }
        }
        vis[curr] = false;
        return res;
    }
}