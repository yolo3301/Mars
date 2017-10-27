class Solution {
    public int maxKilledEnemies(char[][] grid) {
        int m = grid.length;
        if (m == 0) return 0;
        int n = grid[0].length;
        if (n == 0) return 0;

        int[][] row = new int[m][n];
        for (int i = 0; i < m; i++) {
            int sum = 0;
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 'W') sum=0;
                row[i][j] = sum;
                if (grid[i][j] == 'E') sum++;
            }

            sum = 0;
            for (int j = n-1; j >= 0; j--) {
                if (grid[i][j] == 'W') sum=0;
                row[i][j] += sum;
                if (grid[i][j] == 'E') sum++;
            }
        }

        int ret = 0;
        for (int j = 0; j < n; j++) {
            int[] col = new int[m];
            int sum = 0;
            for (int i = 0; i < m; i++) {
                if (grid[i][j] == 'W') sum=0;
                col[i] = sum;
                if (grid[i][j] == 'E') sum++;
            }

            sum = 0;
            for (int i = m-1; i >= 0; i--) {
                if (grid[i][j] == 'W') sum=0;
                col[i] += sum;
                if (grid[i][j] == 'E') sum++;

                if (grid[i][j] == '0')
                    ret = Math.max(ret, col[i]+row[i][j]);
            }
        }

        return ret;
    }
}
