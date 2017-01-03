// https://discuss.leetcode.com/topic/27261/clean-kmp-solution-with-super-detailed-explanation
public class Solution {
    public String shortestPalindrome(String s) {
        if (s.length() < 2) return s;
        String tmp = s + "#" + new StringBuilder(s).reverse().toString();
        int[] b = preProcess(tmp);
        int last = b[tmp.length()];

        return new StringBuilder(s.substring(last)).reverse().append(s).toString();
    }

    private int[] preProcess(String s) {
        int len = s.length();
        int[] b = new int[len+1];
        int i = 0, j = -1;
        b[i] = j;

        while (i < len) {
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
