public class Solution {
    public String frequencySort(String s) {
        if (s.isEmpty()) return s;

        HashMap<Character, Integer> cnt = new HashMap<>();
        TreeMap<Integer, List<Character>> map = new TreeMap<>();
        for (char ch : s.toCharArray()) {
            if (cnt.containsKey(ch)) {
                cnt.put(ch, cnt.get(ch)+1);
            } else {
                cnt.put(ch, 1);
            }
        }
        for (Map.Entry<Character, Integer> e : cnt.entrySet()) {
            if (!map.containsKey(e.getValue()))
                map.put(e.getValue(), new ArrayList<Character>());
            map.get(e.getValue()).add(e.getKey());
        }

        StringBuilder sb = new StringBuilder();
        while (!map.isEmpty()) {
            Map.Entry<Integer, List<Character>> next = map.pollLastEntry();
            for (Character ch : next.getValue()) {
                for (int i = 0; i < next.getKey(); i++) sb.append(ch);
            }
        }

        return sb.toString();
    }
}
