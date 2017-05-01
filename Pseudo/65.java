public class Solution {
    public boolean isNumber(String s) {
        if (s.length() == 0) return false;
        s = s.trim();
        boolean seenNum = false, seenDot = false, seenE = false, seenNumAfterE = false;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                if (seenE && !seenNum) return false;
                if (seenE) seenNumAfterE = true;
                else seenNum = true;
            } else if (ch == '.') {
                if (seenDot || seenE) return false;
                seenDot = true;
            } else if (ch == 'e') {
                if (seenE || !seenNum) return false;
                seenE = true;
            } else if (ch == '+' || ch == '-') {
                if (i - 1 >= 0 && s.charAt(i-1) != 'e') return false;
            } else {
                return false;
            }
        }

        if (seenE && !seenNumAfterE) return false;
        return seenNum;
    }
}