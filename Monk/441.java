public class Solution {
    public int arrangeCoins(int n) {
        long x = (long) (Math.sqrt(1 + 8 * (long)n) - 1) / 2;
        return (int)x;
    }
}