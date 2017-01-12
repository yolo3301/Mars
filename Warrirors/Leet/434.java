public class Solution {
    public int countSegments(String s) {
        int res = 0;
        boolean seg = false;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ' && !seg) {
                res++;
                seg = true;
            } else if (s.charAt(i) == ' ') {
                seg = false;
            }
        }

        return res;
    }
}
