class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int len = difficulty.length;
        int[][] pair = new int[len][2];
        for (int i = 0; i < len; i++) {
            pair[i][0] = difficulty[i];
            pair[i][1] = profit[i];
        }

        Arrays.sort(pair, (a, b) -> {
            return a[0] - b[0];
        });

        int[] preMax = new int[len];
        int max = pair[0][1];
        for (int i = 0; i < len; i++) {
            max = Math.max(max, pair[i][1]);
            preMax[i] = max;
        }

        int ret = 0;
        for (int w : worker) {
            int cur = less(pair, w);
            if (cur >= 0)
                ret += preMax[cur];
        }

        return ret;
    }

    private int less(int[][] p, int t) {
        int s = 0, e = p.length-1;
        while (s <= e) {
            int m = s + (e - s) / 2;
            if (p[m][0] <= t) {
                if (m+1 > e || p[m+1][0] > t) return m;
                s = m+1;
            } else {
                e = m-1;
            }
        }

        return e;
    }
}