public class Solution {
    public String findLongestWord(String s, List<String> d) {
        if (s.length() == 0 || d.isEmpty()) return "";
        Collections.sort(d, (a, b) -> {
            if (a.length() != b.length()) return b.length() - a.length();
            return a.compareTo(b);
        });

        int[] cnt = new int[26];
        for (char ch : s.toCharArray()) {
            cnt[ch - 'a']++;
        }

        for (String w : d) {
            if (canForm(s, cnt, w)) return w;
        }

        return "";
    }

    private boolean canForm(String s, int[] cnt, String w) {
        if (s.length() < w.length()) return false;
        int[] local = new int[26];
        for (char ch : w.toCharArray()) {
            if (++local[ch - 'a'] > cnt[ch - 'a']) return false;
        }

        for (int i = 0, j = 0; i < s.length(); i++) {
            if (s.charAt(i) == w.charAt(j)) j++;
            if (j == w.length()) return true;
        }

        return false;
    }
}