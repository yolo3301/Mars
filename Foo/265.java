public class Solution {
    public int minCostII(int[][] costs) {
        int n = costs.length;
        if (n == 0) return 0;
        int k = costs[0].length;
        if (k == 0) return 0;

        int[][] m1 = new int[n][2];
        int[][] m2 = new int[n][2];
        for (int i = 0; i < n; i++) {
            int l1 = Integer.MAX_VALUE, l2 = Integer.MAX_VALUE;
            int c1 = -1, c2 = -1;
            for (int j = 0; j < k; j++) {
                if (i == 0) {
                    if (costs[i][j] < l1) {
                        l2 = l1;
                        c2 = c1;
                        l1 = costs[i][j];
                        c1 = j;
                    } else if (costs[i][j] < l2) {
                        l2 = costs[i][j];
                        c2 = j;
                    }
                } else {
                    int curr = costs[i][j];
                    if (j != m1[i-1][1]) {
                        curr += m1[i-1][0];
                    } else {
                        curr += m2[i-1][0];
                    }

                    if (curr < l1) {
                        l2 = l1;
                        c2 = c1;
                        l1 = curr;
                        c1 = j;
                    } else if (curr < l2) {
                        l2 = curr;
                        c2 = j;
                    }
                }
            }
            m1[i][0] = l1;
            m1[i][1] = c1;
            m2[i][0] = l2;
            m2[i][1] = c2;
        }

        return m1[n-1][0];
    }
}