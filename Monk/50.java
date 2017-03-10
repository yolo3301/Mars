public class Solution {
    public double myPow(double x, int n) {
        if (x == 1.0) return 1.0;
        if (n == 0) return 1;
        if (n < 0 && n != Integer.MIN_VALUE) return 1.0 / myPow(x, -n);
        if (n == Integer.MIN_VALUE) return 1.0 / (x * myPow(x, Integer.MAX_VALUE);
        if (n == 1) return x;
        double y = myPow(x , n / 2);
        if (n % 2 == 0) return y * y;
        else return x * y * y;
    }
}

// Use x * x to avoid overflow
public class Solution {
    public double myPow(double x, int n) {
        if(n == 0) { return 1.0; }
        if(x == 0) { return 0.0; }
        
        if(n % 2 == 0) {
            return myPow(x * x, n / 2);
        } else {
            return (n > 0 ? x : 1.0 / x ) * myPow(x * x, n / 2) ;
        }
    }
}