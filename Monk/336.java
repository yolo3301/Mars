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

                if (isPan(s1)) {
                    String sr2 = new StringBuilder(s2).reverse().toString();
                    if (map.containsKey(sr2) && map.get(sr2) != i) {
                        res.add(Arrays.asList(map.get(sr2), i));
                    }
                }

                if (s2.length() != 0 && isPan(s2)) {
                    String sr1 = new StringBuilder(s1).reverse().toString();
                    if (map.containsKey(sr1) && map.get(sr1) != i ) {
                        res.add(Arrays.asList(i, map.get(sr1)));
                    }
                }
            }
        }

        return res;
    }

    private boolean isPan(String s) {
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - i - 1))
                return false;
        }
        return true;
    }
}