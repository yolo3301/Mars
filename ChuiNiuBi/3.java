/*
Longest Substring Without Repeating Characters
*/

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0)
            return 0;

        HashSet<Characters> set = new HashSet<Characters>();
        int start = 0, max = 0;

        for (int i = 0; i < s.length(); i++) {
            if (set.contains(s.charAt(i))) {
                while (start < i && s.charAt(i) != s.charAt(start)) {
                    set.remove(s.charAt(start));
                    start++;
                }
                start++;
            } else {
                set.add(s.charAt(i));
                max = Math.max(max, i - start + 1);
            }
        }

        return max;
    }
}