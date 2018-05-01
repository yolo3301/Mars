class Solution {
    public int bestRotation(int[] A) {
        int[] bad = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            int s = (i - A[i] + 1 + A.length) % A.length;
            int e = (i + 1) % A.length;
            bad[s]--;
            bad[e]++;
            if (s > e)
                bad[0]--;
        }

        int best = -A.length;
        int ret = 0, acc = 0;
        for (int i = 0; i < A.length; i++) {
            acc += bad[i];
            if (acc > best) {
                best = acc;
                ret = i;
            }
        }

        return ret;
    }
}