public class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (s.length() < p.length()) return res;

        int[] count = new int[26];
        for (int i = 0; i < p.length(); i++) {
            char ch = p.charAt(i);
            count[ch - 'a']++;
        }

        int[] run = new int[26];
        for (int i = 0; i < p.length(); i++) {
            char ch = s.charAt(i);
            run[ch - 'a']++;
        }

        if (isMatch(run, count)) res.add(0);

        for (int i = p.length(); i < s.length(); i++) {
            char delete = s.charAt(i - p.length());
            char add = s.charAt(i);

            run[delete - 'a']--;
            run[add - 'a']++;

            if (isMatch(run, count)) res.add(i - p.length() + 1);
        }

        return res;
    }

    private boolean isMatch(int[] v1, int[] v2) {
        for (int i = 0; i < 26; i++) {
            if (v1[i] != v2[i]) return false;
        }
        return true;
    }
}
