public class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;
        Map<Character, Character> map1 = new HashMap<>();
        Map<Character, Character> map2 = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            if (map1.containsKey(s.charAt(i))) {
                if (t.charAt(i) != map1.get(s.charAt(i))) return false;
            } else if (map2.containsKey(t.charAt(i))) {
                if (s.charAt(i) != map2.get(t.charAt(i))) return false;
            } else {
                map1.put(s.charAt(i), t.charAt(i));
                map2.put(t.charAt(i), s.charAt(i));
            }
        }

        return true;
    }
}