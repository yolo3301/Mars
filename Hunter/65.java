public class Solution {
    public boolean isNumber(String s) {
        s = s.trim();

        boolean dot = false, e = false, num = false, numAfterE = false;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == 'e') {
                if (e) return false;
                if (!num) return false;
                e = true;
            } else if (ch == '.') {
                if (dot) return false;
                if (e) return false;
                dot = true;
            } else if (Character.isDigit(ch)) {
                if (e) numAfterE = true;
                else num = true;
            } else if (ch == '-' || ch == '+') {
                if (i != 0 && s.charAt(i-1) != 'e')
                    return false;
            } else {
                return false;
            }
        }

        return num && (!e || numAfterE);
    }
}