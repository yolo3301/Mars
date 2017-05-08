public class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (k == 0 || s.length() == 0) return 0;
        Map<Character, Integer> cnt = new HashMap<>();

        int res = 0;
        for (int i = 0, j = 0; i < s.length(); i++) {
            cnt.put(s.charAt(i), cnt.getOrDefault(s.charAt(i), 0)+1);
            while (cnt.size() > k) {
                int f = cnt.get(s.charAt(j));
                if (f == 1) {
                    cnt.remove(s.charAt(j));
                } else {
                    cnt.put(s.charAt(j), f-1);
                }
                j++;
            }

            res = Math.max(res, i-j+1);
        }

        return res;
    }
}