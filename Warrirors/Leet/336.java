public class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new ArrayList<>();
        if (words.length < 2) return res;

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) map.put(words[i], i);
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j <= words[i].length(); j++) {
                String s1 = words[i].substring(0, j);
                String s2 = words[i].substring(j);
                if (isPal(s1)) {
                    String s2rvs = new StringBuilder(s2).reverse().toString();
                    if (map.containsKey(s2rvs) && map.get(s2rvs) != i) {
                        List<Integer> curr = new ArrayList<>();
                        curr.add(map.get(s2rvs));
                        curr.add(i);
                        res.add(curr);
                    }
                }

                if (isPan(s2)) {
                    String s1rvs = new StringBuilder(s1).reverse().toString();
                    // s2.length() != 0 is important to avoid duplicates
                    if (map.containsKey(s1rvs) && map.get(s1rvs) != i && s2.length() != 0) {
                        List<Integer> curr = new ArrayList<>();
                        curr.add(i);
                        curr.add(map.get(s1rvs));
                        res.add(curr);
                    }
                }
            }
        }

        return res;
    }

    private boolean isPal(String s) {
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i))
                return false;
        }
        return true;
    }
}
