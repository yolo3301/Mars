// https://discuss.leetcode.com/topic/30941/here-is-a-10-line-template-that-can-solve-most-substring-problems
public class Solution {
    public String minWindow(String s, String t) {
        if (t.isEmpty()) return "";

        Map<Character, Integer> count = new HashMap<>();
        int tlen = t.length();
        for (char ch : t.toCharArray()) {
            if (count.containsKey(ch)) {
                count.put(ch, count.get(ch) + 1);
            } else {
                count.put(ch, 1);
            }
        }

        Map<Character, Integer> fly = new HashMap<>();
        String cand = null;
        int cc = 0;

        for (int i = 0, j = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            if (count.containsKey(curr)) {
                if (fly.containsKey(curr)) {
                    fly.put(curr, fly.get(curr) + 1);
                } else {
                    fly.put(curr, 1);
                }

                if (fly.get(curr) <= count.get(curr)) cc++;
            }

            if (cc >= tlen) {
                while (j <= i && cc >= tlen) {
                    char tmp = s.charAt(j);
                    if (fly.containsKey(tmp)) {
                        fly.put(tmp, fly.get(tmp) - 1);
                        if (fly.get(tmp) < count.get(tmp)) cc--;
                    }
                    j++;
                }

                String currCand = s.substring(j - 1, i + 1);
                if (cand == null || cand.length() > currCand.length()) {
                    cand = currCand;
                }
            }
        }

        if (cand == null) return "";
        return cand;
    }
}
