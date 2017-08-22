class Solution {
    public int[][] imageSmoother(int[][] M) {
        int m = M.length;
        int n = M[0].length;
        int[][] res = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res[i][j] = avg(M, i, j);
            }
        }

        return res;
    }

    private int avg(int[][] M, int x, int y) {
        int cnt = 1, sum = M[x][y];
        if (x - 1 >= 0) {
            if (y - 1 >= 0) {
                sum += M[x-1][y-1];
                cnt++;
            }
            sum += M[x-1][y];
            cnt++;
            if (y + 1 < M[0].length) {
                sum += M[x-1][y+1];
                cnt++;
            }
        }
        if (x + 1 < M.length) {
            if (y - 1 >= 0) {
                sum += M[x+1][y-1];
                cnt++;
            }
            sum += M[x+1][y];
            cnt++;
            if (y + 1 < M[0].length) {
                sum += M[x+1][y+1];
                cnt++;
            }
        }
        if (y - 1 >= 0) {
            sum += M[x][y-1];
            cnt++;
        }
        if (y + 1 < M[0].length) {
            sum += M[x][y+1];
            cnt++;
        }
        return sum / cnt;
    }
}