public class WordDistance {

    Map<String, List<Integer>> map = new HashMap<>();

    public WordDistance(String[] words) {
        for (int i = 0; i < words.length; i++) {
            if (!map.containsKey(words[i])) {
                map.put(words[i], new ArrayList<>());
            }
            map.get(words[i]).add(i);
        }
    }
    
    public int shortest(String word1, String word2) {
        List<Integer> l1 = map.get(word1);
        List<Integer> l2 = map.get(word2);
        int j = 0, k = 0, res = Integer.MAX_VALUE;
        while (j < l1.size() && k < l2.size()) {
            res = Math.min(res, Math.abs(l1.get(j)-l2.get(k)));
            if (l1.get(j) <= l2.get(k)) j++;
            else k++; 
        }

        return res;
    }
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(words);
 * int param_1 = obj.shortest(word1,word2);
 */