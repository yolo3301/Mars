public class Solution {
    public boolean wordPatternMatch(String pattern, String str) {
        return bt(pattern, 0, str, 0, new HashMap<>(), new HashMap<>());
    }

    private boolean bt(String pattern, int i, String str, int j,
        Map<Character, String> map1, Map<String, Character> map2) { // need 2 map because of bi-direction
        
        if (i == pattern.length() && j == str.length())
            return true;

        if (i == pattern.length() || j == str.length())
            return false;

        char curr = pattern.charAt(i);
        if (map1.containsKey(curr)) {
            String expect = map1.get(curr);
            String actual = j+expect.length() <= str.length() ? str.substring(j, j+expect.length()) : "";
            if (expect.equals(actual)) {
                return bt(pattern, i+1, str, j+expect.length(), map1, map2);
            }
        } else {
            for (int k = j+1; k <= str.length(); k++) {
                String match = str.substring(j, k);
                if (map2.containsKey(match)) continue;

                map1.put(curr, match);
                map2.put(match, curr);
                boolean res = bt(pattern, i+1, str, k, map1, map2);
                map1.remove(curr);
                map2.remove(match);
                if (res) return true;
            }
        }

        return false;
    }
}