public class Solution {
    public void reverseWords(char[] s) {
        reverse(s, 0, s.length-1);
        for (int i = 0; i < s.length; i++) {
            if (s[i] == ' ') continue;
            int j = i;
            while (j < s.length && s[j] != ' ') j++;
            reverse(s, i, j-1);
            i = j;
        }
    }

    private void reverse(char[] s, int i, int j) {
        for (int k = 0; k < (j-i+1)/2; k++) {
            swap(s, i+k, j-k);
        }
    }

    private void swap(char[] s, int i, int j) {
        char tmp = s[i];
        s[i] = s[j];
        s[j] = tmp;
    }
}