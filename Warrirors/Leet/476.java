public class Solution {
    public int findComplement(int num) {
        if (num == 0) return 1;
        int c = 0, n = num;
        while (n != 0) {
            c++;
            n >>= 1;
        }

        int mask = 0;
        while (c-- > 0) {
            mask <<= 1;
            mask += 1;
        }

        return num ^ mask;
    }
}
