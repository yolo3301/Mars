/*
Palindrome Number

Determine whether an integer is a palindrome. Do this without extra space.
*/

public class Solution {
    public boolean isPalindrome(int x) {
        // do reverse, 判断最终结果
        if (x < 0)
            return false;
        int k = 0, p = x;
        while (x != 0) {
            k = k * 10 + x % 10;
            x = x / 10;
        }
        
        return k == p;
    }
}