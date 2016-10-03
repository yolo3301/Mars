public class Solution {
    public boolean isAnagram(String s, String t) {
        if (s == null && t == null) return true;
        if (s.length() != t.length()) return false;
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            if (--count[t.charAt(i) - 'a'] < 0)
                return false;
        }

        return true;
    }
}


// General solution
public class Solution {
    public boolean isAnagram(String s, String t) {
        if (s == null && t == null) return true;
        if (s.length() != t.length()) return false;

        Map<Character, Integer> count = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            if (count.containsKey(s.charAt(i))) {
                count.put(s.charAt(i), count.get(s.charAt(i)) + 1);
            } else {
                count.put(s.charAt(i), 1);
            }
        }

        int num = t.length();
        for (int j = 0; j < t.length(); j++) {
            if (count.containsKey(t.charAt(j))) {
                if (count.get(t.charAt(j)) > 0) {
                    count.put(t.charAt(j), count.get(t.charAt(j)) - 1);
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }

        return true;
    }
}
