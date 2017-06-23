public class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
        Map<String, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            if (!map.containsKey(words[i])) {
                map.put(words[i], new ArrayList<>());
            }
            map.get(words[i]).add(i);
        }

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

public class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
        int res = Integer.MAX_VALUE, j = -1, k = -1;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                j = i;
            }
            if (words[i].equals(word2)) {
                k = i;
            }

            if (j >= 0 && k >= 0) {
                res = Math.min(res, Math.abs(j-k));
            }
        }

        return res;
    }
}