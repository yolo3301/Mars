public class Solution {
    public boolean checkRecord(String s) {
        int a = 0, l = 0;
        for (char ch : s.toCharArray()) {
            if (ch == 'L') {
                if (++l > 2) return false;
            } else {
                l = 0;
                if (ch == 'A') a++;
            }
        }
        return a <= 1;
    }
}