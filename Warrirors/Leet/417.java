public class Solution {
    public List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> res = new ArrayList<>();
        int m = matrix.length;
        if (m == 0) return res;
        int n = matrix[0].length;
        if (n == 0) return res;

        int[][] helper = new int[m][n];
        for (int i = 0; i < m; i++) {
            fill(matrix, helper, i, 0, m, n);
        }
        for (int j = 1; j < n; j++) {
            fill(matrix, helper, 0, j, m, n);
        }
        for (int i = 0; i < m; i++) {
            find(matrix, helper, i, n - 1, m, n, res);
        }
        for (int j = 0; j < n; j++) {
            find(matrix, helper, m - 1, j, m, n, res);
        }

        return res;
    }

    private void fill(int[][] matrix, int[][] helper, int x, int y, int m, int n) {
        if (helper[x][y] == 1) return;
        helper[x][y] = 1;
        if (x - 1 >= 0 && matrix[x][y] <= matrix[x-1][y])
            fill(matrix, helper, x-1, y, m, n);
        if (x + 1 < m && matrix[x][y] <= matrix[x+1][y])
            fill(matrix, helper, x+1, y, m, n);
        if (y - 1 >= 0 && matrix[x][y] <= matrix[x][y-1])
            fill(matrix, helper, x, y-1, m, n);
        if (y + 1 < n && matrix[x][y] <= matrix[x][y+1])
            fill(matrix, helper, x, y+1, m, n);
    }

    private void find(int[][] matrix, int[][] helper, int x, int y, int m, int n, List<int[]> res) {
        if (helper[x][y] == 3 || helper[x][y] == 2) return;
        if (helper[x][y] == 1) {
            res.add(new int[] {x, y});
            helper[x][y] = 2;
        } else {
            helper[x][y] = 3;
        }

        if (x - 1 >= 0 && matrix[x][y] <= matrix[x-1][y])
            find(matrix, helper, x-1, y, m, n, res);
        if (x + 1 < m && matrix[x][y] <= matrix[x+1][y])
            find(matrix, helper, x+1, y, m, n, res);
        if (y - 1 >= 0 && matrix[x][y] <= matrix[x][y-1])
            find(matrix, helper, x, y-1, m, n, res);
        if (y + 1 < n && matrix[x][y] <= matrix[x][y+1])
            find(matrix, helper, x, y+1, m, n, res);
    }
}
