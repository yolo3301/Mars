public class Solution {
    public int numDecodings(String s) {
        if (s.length() == 0) return 0;
        if (s.charAt(0) == '0') return 0;
        int[] count = new int[s.length() + 1];
        count[0] = 1;
        count[1] = 1;
        for (int i = 2; i <= s.length(); i++) {
            char curr = s.charAt(i-1);
            char last = s.charAt(i-2);
            if (curr != '0') count[i] += count[i-1];
            if (last == '0' + 1 || (last == '0' + 2 && curr <= '0' + 6)) {
                count[i] += count[i-2];
            }
        }

        return count[s.length()];
    }
}
