class Solution {
    public int binaryGap(int N) {
        int idx = 0, last = -1, ret = 0;
        while (N > 0) {
            if (N % 2 == 1) {
                if (last != -1) {
                    ret = Math.max(ret, idx - last);
                }
                last = idx;
            }
            idx++;
            N /= 2;
        }
        return ret;
    }
}