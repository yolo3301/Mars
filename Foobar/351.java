class Solution {
    public int numberOfPatterns(int m, int n) {
        int[][] pass = new int[10][10];
        pass[1][3] = pass[3][1] = 2;
        pass[1][7] = pass[7][1] = 4;
        pass[1][9] = pass[9][1] = 5;
        pass[3][7] = pass[7][3] = 5;
        pass[3][9] = pass[9][3] = 6;
        pass[7][9] = pass[9][7] = 8;
        pass[4][6] = pass[6][4] = 5;
        pass[2][8] = pass[8][2] = 5;

        boolean[] visited = new boolean[10];
        for (int i = 1; i <= 9; i++) {
            visited[i] = true;
            dfs(i, visited, pass, 1, m, n);
            visited[i] = false;
        }

        return res;
    }

    int res = 0;

    private void dfs(int curr, boolean[] visited, int[][] pass, int len, int m, int n) {
        if (len >= m && len <= n) res++;
        if (len == n) return;

        for (int i = 1; i <= 9; i++) {
            if (i == curr || visited[i]) continue;
            if (pass[curr][i] == 0 || visited[pass[curr][i]]) {
                visited[i] = true;
                dfs(i, visited, pass, len+1, m, n);
                visited[i] = false;
            }
        }
    }
}