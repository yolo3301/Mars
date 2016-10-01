public class Solution {
    public char findTheDifference(String s, String t) {
        if (s.length() == 0) return t.charAt(0);

        char[] ch1 = s.toCharArray();
        char[] ch2 = t.toCharArray();
        char r = ch1[0];
        for (int i = 1; i < ch1.length; i++) {
            r ^= ch1[i];
        }
        for (int i = 0; i < ch2.length; i++) {
            r ^= ch2[i];
        }
        return r;
    }
}
