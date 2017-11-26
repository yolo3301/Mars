class Solution {
    public boolean areSentencesSimilarTwo(String[] words1, String[] words2, String[][] pairs) {
        if (words1.length != words2.length) return false;

        Map<String, Set<String>> map = new HashMap<>();
        for (String[] p : pairs) {
            if (!map.containsKey(p[0])) map.put(p[0], new HashSet<>());
            if (!map.containsKey(p[1])) map.put(p[1], new HashSet<>());
            map.get(p[0]).add(p[1]);
            map.get(p[1]).add(p[0]);
        }

        Map<String, Set<String>> cache = new HashMap<>();

        for (int i = 0; i < words1.length; i++) {
            String w1 = words1[i];
            String w2 = words2[i];

            if (w1.equals(w2)) continue;
            if (cache.containsKey(w1) && cache.get(w1).contains(w2)) continue;

            // Lazy init
            if (existSimilar(w1, w2, map, cache)) continue;

            return false;
        }

        return true;
    }

    private boolean existSimilar(String word, String target,
        Map<String, Set<String>> map, Map<String, Set<String>> cache) {
        if (!map.containsKey(word)) return false;
        Queue<String> q = new LinkedList<>();
        q.add(word);
        Set<String> set = new HashSet<>();

        while (!q.isEmpty()) {
            String cur = q.remove();
            set.add(cur);
            for (String n : map.get(cur)) {
                if (!set.contains(n)) {
                    set.add(n);
                    q.add(n);
                }
            }
        }

        for (String s : set) {
            cache.put(s, set);
        }

        return set.contains(target);
    }
}