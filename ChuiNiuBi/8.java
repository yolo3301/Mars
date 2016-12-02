/*
String to Integer (atoi)

Implement atoi to convert a string to an integer.

Hint: Carefully consider all possible input cases. If you want a challenge, please do not see below and ask yourself what are the possible input cases.

Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). You are responsible to gather all the input requirements up front.
*/

public class Solution {
    public int myAtoi(String str) {
        if (str == null)
            return 0;
            
        str = str.trim();
        if (str.length() == 0)
            return 0;
            
        int sign = 1;
        int index = 0;
        
        if (str.charAt(index) == '+') {
            index++;
        } else if (str.charAt(index) == '-') {
            sign = -1;
            index++;
        }
        long num = 0;
        for (; index < str.length(); index++) {
            if (str.charAt(index) < '0' || str.charAt(index) > '9')
                break;
            num = num * 10 + (str.charAt(index)-'0');
            if (num > Integer.MAX_VALUE)
                break;
        }
        if (num * sign >= Integer.MAX_VALUE)
            return Integer.MAX_VALUE;
        if (num * sign <= Integer.MIN_VALUE)
            return Integer.MIN_VALUE;
        return (int)num * sign;
    }
}