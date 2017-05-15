public class Solution {
    public int[][] multiply(int[][] A, int[][] B) {
        if (A.length == 0 || A[0].length == 0 || B.length == 0 || B[0].length == 0)
            return new int[0][0];
        int row = A.length;
        int col = B[0].length;

        Map<Integer, Integer>[] rowHash = new HashMap[row];
        Map<Integer, Integer>[] colHash = new HashMap[col];

        for (int i = 0; i < row; i++) {
            rowHash[i] = new HashMap<>();
            for (int j = 0; j < A[0].length; j++) {
                if (A[i][j] != 0) {
                    rowHash[i].put(j, A[i][j]);
                }
            }
        }

        for (int i = 0; i < col; i++) {
            colHash[i] = new HashMap<>();
            for (int j = 0; j < B.length; j++) {
                if (B[j][i] != 0) {
                    colHash[i].put(j, B[j][i]);
                }
            }
        }

        int[][] res = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (rowHash[i].size() < colHash[j].size()) {
                    for (int k : rowHash[i].keySet()) {
                        if (colHash[j].containsKey(k)) {
                            res[i][j] += rowHash[i].get(k) * colHash[j].get(k);
                        }
                    }
                } else {
                    for (int k : colHash[j].keySet()) {
                        if (rowHash[i].containsKey(k)) {
                            res[i][j] += rowHash[i].get(k) * colHash[j].get(k);
                        }
                    }
                }
            }
        }

        return res;
    }
}

public class Solution {
    public int[][] multiply(int[][] A, int[][] B) {
        int m = A.length, n = A[0].length, k = B[0].length;
        int[][] res = new int[m][k];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (A[i][j] != 0) {
                    for (int z = 0; z < k; z++) {
                        res[i][z] += A[i][j] * B[j][z];
                    }
                }
            }
        }

        return res;
    }
}