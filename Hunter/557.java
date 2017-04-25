public class Solution {
    public String reverseWords(String s) {
        if (s.length() <= 1) return s;
        char[] chs = s.toCharArray();
        for (int i = 0, j = 0; i <= s.length(); i++) {
            if (i == chs.length || chs[i] == ' ') {
                reverse(chs, j, i-1);
                j = i+1;
            }
        }
        
        return new String(chs);
    }

    private void reverse(char[] chs, int i, int j) {
        if (i == j) return;
        for (int k = 0; k <= (j-i) / 2; k++) {
            char tmp = chs[i+k];
            chs[i+k] = chs[j-k];
            chs[j-k] = tmp;
        }
    }
}