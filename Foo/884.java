class Solution {
    public String[] uncommonFromSentences(String A, String B) {
        Map<String, Integer> cnt = new HashMap<>();
        String[] s1 = A.split(" ");
        String[] s2 = B.split(" ");
        for (String w : s1) cnt.put(w, cnt.getOrDefault(w, 0)+1);
        for (String w : s2) cnt.put(w, cnt.getOrDefault(w, 0)+1);
        List<String> l = new ArrayList<>();
        for (Map.Entry<String, Integer> e : cnt.entrySet()) {
            if (e.getValue() == 1) l.add(e.getKey());
        }
        return l.toArray(new String[0]);
    }
}