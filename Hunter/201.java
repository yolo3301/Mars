public class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        int x = 0, cnt = 0;
        while (m != n) {
            m >>= 1;
            n >>= 1;
            cnt++;
        }
        x = m;
        for (int i = 0; i < cnt; i++) {
            x <<= 1;
        }

        return x;
    }
}