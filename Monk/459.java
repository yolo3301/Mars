public class Solution {
    public boolean repeatedSubstringPattern(String s) {
        if (s.length() == 0) return true;
        int[] b = kmp(s);
        int suffixLength = b[s.length()];

        return (suffixLength > 0 && (s.length() % (s.length() - suffixLength) == 0));
    }

    private int[] kmp(String s) {
        int[] b = new int[s.length() + 1];
        int i = 0, j = -1;
        b[i] = j;

        while (i < s.length()) {
            while (j >= 0 && s.charAt(i) != s.charAt(j)) {
                j = b[j];
            }

            i++;
            j++;
            b[i] = j;
        }

        return b;
    }
}