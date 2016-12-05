public class Solution {
    public int findSubstringInWraproundString(String p) {
        if (p.length() == 0) return 0;
        char[] chs = p.toCharArray();
        // number of strings can end up with the letter
        int[] map = new int[26];
        // do not need to use count actually
        int[] count = new int[p.length()];
        count[0] = 1;
        map[p.charAt(0) - 'a'] = 1;

        for (int i = 1; i < p.length(); i++) {
            char last = p.charAt(i-1);
            char curr = p.charAt(i);
            if (prev(curr) == last) {
                count[i] = count[i-1] + 1;
            } else {
                count[i] = 1;
            }
            map[curr - 'a'] = Math.max(map[curr - 'a'], count[i]);
        }

        int res = 0;
        for (int c : map) {
            res += c;
        }

        return res;
    }

    private char prev(char ch) {
        if (ch != 'a') return (char)(ch - 1);
        return 'z';
    }
}
