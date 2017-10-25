class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (k >= s.length() || s.length() == 0) return s.length();
        if (k == 0) return 0;

        Map<Character, Integer> cnt = new HashMap<>();
        int ret = 0;

        for (int i = 0, j = 0; j < s.length(); j++) {
            char cur = s.charAt(j);
            cnt.put(cur, cnt.getOrDefault(cur, 0) + 1);
            while (cnt.size() > k) {
                char prev = s.charAt(i++);
                cnt.put(prev, cnt.get(prev) - 1);
                if (cnt.get(prev) == 0) cnt.remove(prev);
            }
            ret = Math.max(ret, j-i+1);
        }

        return ret;
    }
}
