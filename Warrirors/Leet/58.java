public class Solution {
    public int lengthOfLastWord(String s) {
        char[] chs = s.toCharArray();
        int len = 0, curr = 0;
        for (int i = 0; i < chs.length; i++) {
            if (chs[i] == ' ') {
                if (curr > 0) len = curr;
                curr = 0;
            } else {
                curr++;
            }
        }

        if (curr > 0) len = curr;

        return len;
    }
}
