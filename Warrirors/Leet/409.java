public class Solution {
    public int longestPalindrome(String s) {
        if (s == null || s.length() == 0) return 0;
        Map<Character, Integer> count = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (count.containsKey(c)) {
                count.put(c, count.get(c) + 1);
            } else {
                count.put(c, 1);
            }
        }

        int len = 0;
        int single = 0;

        for (Map.Entry<Character, Integer> entry : count.entrySet()) {
            len += (entry.getValue() / 2) * 2;
            if (entry.getValue() % 2 == 1) single = 1;
        }

        return len + single;
    }
}
