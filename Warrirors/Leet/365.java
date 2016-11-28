// reference: https://discuss.leetcode.com/topic/49238/math-solution-java-solution/2
public class Solution {
    public boolean canMeasureWater(int x, int y, int z) {
        if (z > x + y) return false;
        if (x == z || y == z || x + y == z) return true;

        return z % getGCD(x, y) == 0;
    }

    // reference:https://en.wikipedia.org/wiki/Greatest_common_divisor
    private int getGCD(int a, int b) {
        while (b != 0) {
            int tmp = b;
            b = a % b;
            a = tmp;
        }

        return a;
    }
}
