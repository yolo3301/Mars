class Solution {
    public String shortestPalindrome(String s) {
        if (s.length() <= 1) return s;
        String r = new StringBuilder(s).reverse().toString();
        int[] b = kmp(s + "#" + r);
        int suffixLen = b[b.length-1];

        return new StringBuilder(s.substring(suffixLen)).reverse().append(s).toString();
    }

    private int[] kmp(String s) {
        int[] b = new int[s.length()+1];
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
