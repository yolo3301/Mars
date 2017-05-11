public class Solution {
    public int maxKilledEnemies(char[][] grid) {
        int m = grid.length;
        if (m == 0) return 0;
        int n = grid[0].length;

        int[] erow = new int[m];
        int[] ecol = new int[n];
        int[][] cnt = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '0') {
                    if (erow[i] > 0) cnt[i][j] += erow[i];
                    if (ecol[j] > 0) cnt[i][j] += ecol[j];
                } else if (grid[i][j] == 'E') {
                    erow[i]++;
                    ecol[j]++;
                } else if (grid[i][j] == 'W') {
                    erow[i] = 0;
                    ecol[j] = 0;
                }
            }
        }

        Arrays.fill(erow, 0);
        Arrays.fill(ecol, 0);
        int res = 0;
        for (int i = m-1; i >= 0; i--) {
            for (int j = n-1; j >= 0; j--) {
                if (grid[i][j] == '0') {
                    if (erow[i] > 0) cnt[i][j] += erow[i];
                    if (ecol[j] > 0) cnt[i][j] += ecol[j];
                    res = Math.max(res, cnt[i][j]);
                } else if (grid[i][j] == 'E') {
                    erow[i]++;
                    ecol[j]++;
                } else if (grid[i][j] == 'W') {
                    erow[i] = 0;
                    ecol[j] = 0;
                }
            }
        }

        return res;
    }
}