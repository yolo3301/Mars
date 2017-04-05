public class Solution {
    public int findLUSlength(String[] strs) {
        Map<String, Integer> map = new HashMap<>();
        for (String s : strs) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        Arrays.sort(strs, (a, b) -> {
            return b.length() - a.length();
        });

        for (int i = 0; i < strs.length; i++) {
            if (map.get(strs[i]) == 1) {
                int j;
                for (j = 0; j < i; j++) {
                    if (isSub(strs[i], strs[j]))
                        break;
                }

                if (i == j) return strs[i].length();
            }
        }

        return -1;
    }

    private boolean isSub(String s1, String s2) {
        for (int i = 0, j = 0; i < s1.length(); i++) {
            while (j < s2.length() && s1.charAt(i) != s2.charAt(j)) j++;
            if (j == s2.length()) return false;
            j++;
        }
        return true;
    }
}