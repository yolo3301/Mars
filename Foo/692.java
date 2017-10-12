class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> cnt = new HashMap<>();
        for (String w : words) {
            cnt.put(w, cnt.getOrDefault(w, 0)+1);
        }

        List<String>[] buckets = new ArrayList[words.length+1];
        
        for (String w : cnt.keySet()) {
            if (buckets[cnt.get(w)] == null) {
                buckets[cnt.get(w)] = new ArrayList<>();
            }
            buckets[cnt.get(w)].add(w);
        }

        List<String> ret = new ArrayList<>();
        for (int i = words.length; i >= 0; i--) {
            if (buckets[i] != null) {
                Collections.sort(buckets[i]);
                if (ret.size() + buckets[i].size() <= k) {
                    ret.addAll(buckets[i]);
                } else {
                    ret.addAll(buckets[i].subList(0, k-ret.size()));
                }
            }
            
            if (ret.size() == k) break;
        }

        return ret;
    }
}
