public class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new ArrayList<>();
        if (words.length < 2) return res;

        Map<String, Integer> index = new HashMap<>();
        for (int i = 0; i < words.length; i++) index.put(words[i], i);

        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j <= words[i].length(); j++) {
                String s1 = words[i].substring(0, j);
                String s2 = words[i].substring(j);

                if (isPan(s1)) {
                    String s2r = new StringBuilder(s2).reverse().toString();
                    if (index.containsKey(s2r) && index.get(s2r) != i) {
                        res.add(Arrays.asList(index.get(s2r), i));
                    }
                }

                if (s2.length() != 0 && isPan(s2)) {
                    String s1r = new StringBuilder(s1).reverse().toString();
                    if (index.containsKey(s1r) && index.get(s1r) != i) {
                        res.add(Arrays.asList(i, index.get(s1r)));
                    }
                }
            }
        }

        return res;
    }

    private boolean isPan(String s) {
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i))
                return false;
        }

        return true;
    }
}