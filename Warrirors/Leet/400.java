public class Solution {
    public int findNthDigit(int n) {
        if (n <= 9) return n;
        long start = 1, upper = 9, digit = 1, last = 0;
        while (n > upper) {
            start *= 10;
            digit++;
            last = upper;
            upper += 9 * digit * start;
        }

        long x = (n - last - 1) / digit;

        long y = (n - last - 1) % digit;

        long target = start + x;

        long z = start;
        for (int i = 0; i < y; i++) {
            z /= 10;
        }

        return (int) (target / z) % 10;
    }
}
