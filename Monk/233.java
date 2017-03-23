public class Solution {
    public int countDigitOne(int n) {
        int res = 0;
        for (long k = 1; k <= n; k *= 10) {
            res += (n/k + 8) / 10 * k + ((n/k)%10 == 1 ? n%k+1 : 0);
        }
        return res;
    }
}