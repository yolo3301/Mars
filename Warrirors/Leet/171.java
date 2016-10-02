public class Solution {
    public int titleToNumber(String s) {
        if (s == null || s.length() == 0) return 0;

        int result = 0;
        int base = 1;
        for (int i = s.length() - 1; i >= 0; i--) {
            int curr = s.charAt(i) - 'A' + 1;
            result += base * curr;
            base *= 26;
        }

        return result;
    }
}


public class Solution {
    public int titleToNumber(String s) {
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int val = c - 'A' + 1;
            result *= 26;
            result += val;
        }
        return result;
    }
}
