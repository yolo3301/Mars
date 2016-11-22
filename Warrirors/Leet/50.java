// https://discuss.leetcode.com/topic/66478/java-solution-beats-96
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
