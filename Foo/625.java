public class Solution {
    public int smallestFactorization(int a) {
        if (a == 1) return 1;
        return helper(a, "");
    }

    private int helper(int a, String buffer) {
        if (a == 1) {
            if (buffer.length() == 0) return 0;
            String r = new StringBuilder(buffer).reverse().toString();
            long l = Long.valueOf(r);
            if (l <= Integer.MAX_VALUE) return (int)l;
            else return 0;
        }

        for (int i = 9; i > 1; i--) {
            if (a % i == 0) {
                return helper(a/i, buffer + i);
            }
        }

        return 0;
    }
}