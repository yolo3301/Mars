class Solution {
    public int countCornerRectangles(int[][] grid) {
        int m = grid.length;
        if (m <= 1) return 0;
        int n = grid[0].length;
        if (n <= 1) return 0;

        boolean flip = (m > n);
        if (flip) {
            int tmp = m;
            m = n;
            n = tmp;
        }

        int ret = 0;

        for (int i = 0; i+1 < m; i++) {
            for (int j = i+1; j < m; j++) {
                int cnt = 0;
                for (int k = 0; k < n; k++) {
                    if (flip) {
                        if (grid[k][i] == 1 && grid[k][j] == 1) {
                            cnt++;
                            ret += Math.max(0, cnt-1);
                        }
                    } else {
                        if (grid[i][k] == 1 && grid[j][k] == 1) {
                            cnt++;
                            ret += Math.max(0, cnt-1);
                        }
                    }
                }
            }
            //System.out.println(ret);
        }

        return ret;
    }
}