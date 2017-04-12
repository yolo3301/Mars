public class Solution {
    public double myPow(double x, int n) {
        if (n == 0) return 1;
        if (n < 0) {
            if (n != Integer.MIN_VALUE)
                return 1.0 / myPow(x, -n);
            else
                return 1.0 / (x * myPow(x, Integer.MAX_VALUE));
        }
        if (n == 1) return x;
        if (x == 1.0) return 1.0;

        double y = myPow(x, n/2);
        if (n % 2 == 0) return y*y;
        else return y*y*x;
    }
}