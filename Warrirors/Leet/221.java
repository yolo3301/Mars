public class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix.length == 0) return 0;
        int result = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        // It's easier to use m+1 and n+1 so that no need to handle < 0 cases
        int[][] mem = new int[m+1][n+1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (matrix[i-1][j-1] == 1) {
                    mem[i][j] = Math.min(Math.min(mem[i-1][j], mem[i][j-1]), mem[i-1][j-1]);
                    result = Math.max(result, mem[i][j]);
                }
            }
        }

        return result * result;
    }
}
