public class Solution {
    public boolean canMeasureWater(int x, int y, int z) {
        if (z > x + y) return false;
        if (z == x || z == y || z == x + y) return true;

        return z % gcd(x, y) == 0;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int tmp = b;
            b = a % b;
            a = tmp;
        }

        return a;
    }
}