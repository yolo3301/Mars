public class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        if (x == 0) return true;

        int len = 0;
        long div = 1;
        while (x / div != 0) {
            div *= 10;
            len++;
        }

        div /= 10;
        int y = x;
        for (int i = 0; i < len / 2; i++) {
            if (x % 10 != (y/div)%10) return false;
            x /= 10;
            div /= 10;
        }

        return true;
    }
}