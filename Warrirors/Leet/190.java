public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        if (n == 0) return 0;
        int res = 0;
        for (int i = 0; i < 32; i++) {
            int curr = (n & 1);
            n = (n >> 1);
            res = (res << 1) + curr;
        }
        return res;
    }
}
