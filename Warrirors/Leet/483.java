public class Solution {
    public String smallestGoodBase(String n) {
        long num = Long.parseLong(n);
        long x = 1;
        for (int i = 60; i >= 1; i--) {
            if ((x << i) < num) {
                long curr = bs(num, i);
                if (curr != -1) return Long.toString(curr);
            }
        }

        return Long.toString(num - 1);
    }

    private long bs(long num, long d) {
        long s = 1, e = (long)(Math.pow(num, 1.0/d)+1);
        while (s <= e) {
            long m = s + (e - s) / 2;
            long sum = 0, p = 1;
            for (int i = 0; i <= d; i++) {
                sum += p;
                p *= m;
            }
            if (sum == num) return m;
            else if (sum < num) s = m + 1;
            else e = m - 1;
        }

        return -1;
    }
}