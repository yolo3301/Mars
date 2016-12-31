public class Solution {
    public boolean isScramble(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        int len = s1.length();
        if (len == 0) return true;
        if (len == 1) return s1.charAt(0) == s2.charAt(0);

        int[] cnt1 = new int[26];
        int[] cnt2 = new int[26];
        for (int i = 0; i < len; i++) {
            cnt1[s1.charAt(i) - 'a']++;
            cnt2[s2.charAt(i) - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (cnt1[i] != cnt2[i]) return false;
        }

        for (int i = 1; i < len; i++) {
            String p11 = s1.substring(0, i);
            String p12 = s1.substring(i);
            String p21 = s2.substring(0, i);
            String p22 = s2.substring(i);
            String p23 = s2.substring(0, len - i);
            String p24 = s2.substring(len - i);

            if (isScramble(p11, p21) && isScramble(p12, p22) ||
                isScramble(p11, p24) && isScramble(p12, p23))
                return true;
        }

        return false;
    }
}
