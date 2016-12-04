public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() <= 1) return s.length();

        int res = Integer.MIN_VALUE;
        Set<Character> set = new HashSet<>();
        int i = 0;
        for (int j = 0; j < s.length(); j++) {
            char curr = s.charAt(j);
            if (!set.contains(curr)) {
                set.add(curr);
            } else {
                res = Math.max(res, set.size());
                while (i < j) {
                    char tmp = s.charAt(i);
                    if (tmp == curr) {
                        i++;
                        break;
                    } else {
                        set.remove(tmp);
                        i++;
                    }
                }
            }
        }

        res = Math.max(res, set.size());

        return res;
    }
}
