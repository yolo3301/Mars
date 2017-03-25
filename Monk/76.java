public class Solution {
    public String minWindow(String s, String t) {
        if (t.length() == 0) return "";
        Map<Character, Integer> cnt = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for (char ch : t.toCharArray()) {
            int c = cnt.getOrDefault(ch, 0);
            cnt.put(ch, c + 1);
        }

        int len = 0, res = Integer.MAX_VALUE;
        String cand = "";
        for (int i = 0, j = 0; i < s.length(); i++) {
            if (cnt.containsKey(s.charAt(i))) {
                int wc = window.getOrDefault(s.charAt(i), 0);
                window.put(s.charAt(i), wc + 1);
                if (wc + 1 <= cnt.get(s.charAt(i))) len++;
            }

            if (len == t.length()) {
                while (j <= i && len == t.length()) {
                    int wc = window.getOrDefault(s.charAt(j), 0);
                    if (wc > 1) window.put(s.charAt(j), wc - 1);
                    else if (wc == 1) window.remove(s.charAt(j));

                    if (wc != 0 && wc <= cnt.get(s.charAt(j))) {
                        len--;
                    }
                    j++;
                }

                if (i - j + 2 < res) {
                    res = i - j + 2;
                    cand = s.substring(j-1, i+1);
                }
            }
        }

        return cand;
    }
}