// interesting idea!

public class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0 || (x != 0 && x % 10 == 0)) return false;
        int rev = 0;
        // The condition is when x > rev
        // If rev has more digits than x, then it's just over half of the digits
        // And it will not cause overflow because only half digits
        while (x > rev) {
            rev = rev * 10 + x % 10;
            x /= 10;
        }

        // consider x == rev/10 in case there are odd # of digits
        return x == rev || x == rev / 10;
    }
}
