public class Solution {

    private static int mod = 1337;

    public int superPow(int a, int[] b) {
        if (a % 1337 == 0) return 0;
        if (b.length == 0) return 1;
        return helper(a, b, b.length-1);
    }

    private int helper(int a, int[] b, int index) {
        if (index < 0) return 1;
        return pow(helper(a, b, index-1), 10) * pow(a, b[index]) % mod;
    }

    private int pow(int a, int k) {
        a %= mod;
        int r = 1;
        for (int i = 0; i < k; i++) {
            r = (r * a) % mod;
        }
        return r;
    }
}