public class Solution {
    public boolean repeatedSubstringPattern(String str) {
        int[] b = kmp(str);
        int len = str.length();
        int suffixLen = b[len];

        return (suffixLen > 0 && (len % (len - suffixLen) == 0));
    }

    private int[] kmp(String s) {
        char[] ch = s.toCharArray();
        int[] b = new int[ch.length + 1];
        int i = 0, j = -1;
        b[i] = j;

        while (i < ch.length) {
            while (j >= 0 && ch[i] != ch[j]) {
                j = b[j];
            }

            i++;
            j++;
            b[i] = j;
        }

        return b;
    }
}