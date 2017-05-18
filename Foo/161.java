public class Solution {
    public boolean isOneEditDistance(String s, String t) {
        if (s.equals(t)) return false;
        if (Math.abs(s.length() - t.length()) > 1) return false;

        if (s.length() == t.length()) {
            boolean hasMismatch = false;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) != t.charAt(i)) {
                    if (hasMismatch) return false;
                    hasMismatch = true;
                }
            }
        } else {
            int a = 0, b = 0;
            boolean hasMismatch = false;
            while (a < s.length() && b < t.length()) {
                if (s.charAt(a) == t.charAt(b)) {
                    a++;
                    b++;
                } else {
                    if (hasMismatch) return false;
                    hasMismatch = true;
                    if (s.length() > t.length()) {
                        a++;
                    } else {
                        b++;
                    }
                }
            }
        }

        return true;
    }
}