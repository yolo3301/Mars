public class Solution {
    public String shortestPalindrome(String s) {
        if (s.length() <= 1) return s;
        StringBuilder sb = new StringBuilder(s);
        String x = s + "#" + sb.reverse().toString();
        int[] b = preprocess(x);
        int len = b[b.length-1];

        sb = new StringBuilder();
        for (int i = 0; i < s.length() - len; i++) {
            sb.append(s.charAt(s.length() - 1 - i));
        }
        sb.append(s);
        return sb.toString();
    }

    private int[] preprocess(String s) {
        int[] b = new int[s.length()+1];
        int i = 0, j = -1;
        b[i] = j;

        while (i < s.length()) {
            while (j > 0 && s.charAt(i) != s.charAt(j)) {
                j = b[j];
            }
            b[++i] = ++j;
        }

        return b;
    }
}