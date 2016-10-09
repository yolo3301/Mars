public class Solution {
    public String reverseVowels(String s) {
        if (s == null || s.length() <= 1) return s;

        Set<Character> set = new HashSet<>(Arrays.asList('a','e','i','o','u','A','E','I','O','U'));
        char[] chs = s.toCharArray();
        int i = 0, j = chs.length - 1;

        while (i < j) {
            if (set.contains(chs[i]) && set.contains(chs[j])) {
                char tmp = chs[i];
                chs[i] = chs[j];
                chs[j] = tmp;
                i++;
                j--;
            } else if (!set.contains(chs[i])) {
                i++;
            } else if (!set.contains(chs[j])) {
                j--;
            }
        }

        return String.copyValueOf(chs);
    }
}
