public class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) return 1;

        int res = 10;
        int unique = 9;
        int available = 9;
        while (n-- > 1 && available > 0) {
            unique *= available;
            res += unique;
            available--;
        }

        return res;
    }
}