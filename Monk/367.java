public class Solution {
    public boolean isPerfectSquare(int num) {
        if (num == 1) return true;
        long s = 1, e = num / 2;
        while (s <= e) {
            long x = s + (e - s) / 2;
            long y = x * x;
            if (y == num) return true;
            else if (y > num) e = x - 1;
            else s = x + 1;
        }

        return false;
    }
}