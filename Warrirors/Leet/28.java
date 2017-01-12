public class Solution {
    public int strStr(String haystack, String needle) {
        if (needle.isEmpty()) return 0;
        if (haystack.isEmpty()) return -1;
        int[] b = preProcess(needle);
        int i = 0, j = 0;
        while (i < haystack.length()) {
            while (j >= 0 && needle.charAt(j) != haystack.charAt(i)) {
                j = b[j];
            }
            i++;
            j++;
            if (j == needle.length())
                return i - needle.length();
        }

        return -1;
    }

    private int[] preProcess(String str) {
        char[] chs = str.toCharArray();
        int[] b = new int[chs.length+1];
        int i = 0, j = -1;
        b[i] = j;

        while (i < chs.length) {
            while (j >= 0 && chs[i] != chs[j]) {
                j = b[j];
            }
            i++;
            j++;
            b[i] = j;
        }

        return b;
    }
}
