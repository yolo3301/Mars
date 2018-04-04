class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        double[][] g = new double[102][102]; // 1 indexed, and 102 as the floor
        g[0][0] = (double)poured;

        for (int i = 0; i <= query_row; i++) {
            for (int j = 0; j <= i; j++) {
                double next = (g[i][j] - 1.0) / 2.0;
                if (next > 0) {
                    g[i+1][j] += next;
                    g[i+1][j+1] += next;
                }
            }
        }

        return Math.min(1.0, g[query_row][query_glass]);
    }
}

/**
1 = 1
1 1 = 2
1 2 1 = 4
1 3 3 1 = 8
1 4 6 4 1 = 16
1 5 10 10 5 1 = 32
1 6 15 20 15 6 1 = 64
 */