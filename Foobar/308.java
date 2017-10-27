class NumMatrix {

    int[][] mtx;
    int[][] tree;
    int m, n;

    public NumMatrix(int[][] matrix) {
        m = matrix.length;
        n = m == 0 ? 0 : matrix[0].length;
        tree = new int[m+1][n+1];
        mtx = matrix;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                update2(i, j, matrix[i][j]);
            }
        }
    }
    
    public void update(int row, int col, int val) {
        if (m == 0 || n == 0) return;
        int diff = val - mtx[row][col];
        mtx[row][col] = val;
        update2(row, col, diff);
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        if (m == 0 || n == 0) return 0;
        return sum(row2, col2) + sum(row1-1, col1-1)
            - sum(row1-1, col2) - sum(row2, col1-1);
    }

    private int sum(int x, int y) {
        int ret = 0;
        for (int i = x+1; i > 0; i -= (i & -i)) {
            for (int j = y+1; j > 0; j -= (j & -j)) {
                ret += tree[i][j];
            }
        }

        return ret;
    }

    private void update2(int x, int y, int val) {
        for (int i = x+1; i <= m; i += (i & -i)) {
            for (int j = y+1; j <= n; j += (j & -j)) {
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
