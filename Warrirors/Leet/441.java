public class Solution {
    public int arrangeCoins(int n) {
        int x = (int) Math.sqrt(2L*n);
        return x * (x + 1L) <= 2L * n ? x : x - 1;
    }
}
