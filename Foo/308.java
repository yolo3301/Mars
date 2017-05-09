public class NumMatrix {

    private int[][] mtx;
    private int[][] tree;
    private int m, n;

    public NumMatrix(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return;
        m = matrix.length;
        n = matrix[0].length;
        this.mtx = matrix;
        this.tree = new int[m+1][n+1];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                init(i, j, matrix[i][j]);
            }
        }
    }
    
    public void update(int row, int col, int val) {
        if (m == 0 || n == 0) return;
        int diff = val - mtx[row][col];
        mtx[row][col] = val;
        init(row, col, diff);
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        if (m == 0 || n == 0) return 0;
        return sum(row1-1, col1-1)+sum(row2, col2)-sum(row2, col1-1)-sum(row1-1, col2);
    }

    private int sum(int row, int col) {
        int res = 0;
        for (int i = row+1; i > 0; i -= (i & -i)) {
            for (int j = col+1; j > 0; j -= (j & -j)) {
                res += tree[i][j];
            }
        }

        return res;
    }

    private void init(int row, int col, int val) {
        for (int i = row+1; i <= m; i += (i & -i)) {
            for (int j = col+1; j <= n; j += (j & -j)) {
                tree[i][j] += val;
            }
        }
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * obj.update(row,col,val);
 * int param_2 = obj.sumRegion(row1,col1,row2,col2);
 */