public class NumMatrix {

    private int[][] sumRows;

    public NumMatrix(int[][] matrix) {
        int m = 0, n = 0;
        m = matrix.length;
        if (m > 0) n = matrix[0].length;
        sumRows = new int[m][n];
        for (int i = 0; i < m; i++) {
            fillSumRow(matrix[i], sumRows[i]);
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int res = 0;
        if (sumRows.length == 0) return 0;
        for (int i = row1; i <= row2; i++) {
            int curr = col1 > 0 ? sumRows[i][col2] - sumRows[i][col1-1] : sumRows[i][col2];
            res += curr;
        }

        return res;
    }

    private void fillSumRow(int[] row, int[] sumRow) {
        sumRow[0] = row[0];
        for (int i = 1; i < row.length; i++) {
            sumRow[i] = sumRow[i-1] + row[i];
        }
    }
}


// Your NumMatrix object will be instantiated and called as such:
// NumMatrix numMatrix = new NumMatrix(matrix);
// numMatrix.sumRegion(0, 1, 2, 3);
// numMatrix.sumRegion(1, 2, 3, 4);
