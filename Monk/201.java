public class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        if (m == 0) return 0;

        int cnt = 0;
        while (m != n) {
            m >>= 1;
            n >>= 1;
            cnt++;
        }

        return (m << cnt);
    }
}