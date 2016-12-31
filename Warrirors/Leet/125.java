public class Solution {
    public boolean isPalindrome(String s) {
        if (s.length() <= 1) return true;
        int i = 0, j = s.length() - 1;

        while (i <= j) {
            char left = ' ', right = ' ';
            while (i <= j) {
                char ch = s.charAt(i);
                if (Character.isLetterOrDigit(ch)) {
                    left = ch;
                    break;
                }
                i++;
            }

            while (i <= j) {
                char ch = s.charAt(j);
                if (Character.isLetterOrDigit(ch)) {
                    right = ch;
                    break;
                }
                j--;
            }

            if (i > j) break;

            i++;
            j--;

            if (Character.toUpperCase(left) != Character.toUpperCase(right)) return false;
        }

        return true;
    }
}
