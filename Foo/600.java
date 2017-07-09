public class Solution {
    public int findIntegers(int num) {
        StringBuilder sb = new StringBuilder(Integer.toBinaryString(num)).reverse();
        int len = sb.length();

        int[] a = new int[len]; // non-consecutive ends with 0
        int[] b = new int[len]; // non-consecutive ends with 1
        a[0] = b[0] = 1;
        for (int i = 1; i < len; i++) {
            a[i] = a[i-1] + b[i-1];
            b[i] = a[i-1];
        }

        int res = a[len-1] + b[len-1];
        for (int i = len-2; i >= 0; i--) {
            if (sb.charAt(i) == '1' && sb.charAt(i+1) == '1') break;

            // if sb[i] = 0 sb[i+1] = 0, needs to minus all the cases when sb[i] = 1 --> b[i]
            if (sb.charAt(i) == '0' && sb.charAt(i+1) == '0') res -= b[i];
        }

        return res;
    }
}