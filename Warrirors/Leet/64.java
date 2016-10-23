// if we can modify the original matrix, then we don't need extra space
public class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        if (m == 0) return 0;
        int n = grid[0].length;
        if (n == 0) return 0;

        int[][] mem = new int[m][n];
        mem[0][0] = grid[0][0];
        for (int i = 1; i < m; i++) {
            mem[i][0] = mem[i-1][0] + grid[i][0];
        }
        for (int i = 1; i < n; i++) {
            mem[0][i] = mem[0][i-1] + grid[0][i];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                mem[i][j] = grid[i][j] + Math.min(mem[i-1][j], mem[i][j-1]);
            }
        }

        return mem[m-1][n-1];
    }
}
