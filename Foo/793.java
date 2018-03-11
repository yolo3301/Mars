class Solution {
    public int preimageSizeFZF(int K) {
        long s = K, e = 10L*K + 1; // why?
        while (s < e) {
            long m = s + (e - s) / 2;
            long cnt = tailZeros(m);
            if (cnt == K) return 5;
            if (cnt < K) s = m+1;
            else e = m;
        }

        return 0;
    }

    private long tailZeros(long v) {
        if (v == 0) return 0;
        return v/5 + tailZeros(v/5);
    }
}