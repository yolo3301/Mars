class Solution {
    public int findMinMoves(int[] machines) {
        int len = machines.length;
        int[] sum = new int[len+1];
        for (int i = 0; i < len; i++) {
            sum[i+1] = sum[i] + machines[i];
        }

        if (sum[len] % len != 0) return -1;

        int avg = sum[len] / len;
        int res = 0;

        for (int i = 0; i < len; i++) {
            int left = i * avg - sum[i];
            int right = (len - i - 1) * avg - (sum[len] - sum[i+1]);

            if (left > 0 && right > 0) {
                res = Math.max(res, Math.abs(left)+Math.abs(right));
                // export current to both sides, so only 1 at a time, so need +
            } else {
                res = Math.max(res, Math.max(Math.abs(left), Math.abs(right)));
                // Can import/export at the same time, so max()
            }
        }

        return res;
    }
}