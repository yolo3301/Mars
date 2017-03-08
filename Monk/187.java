public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        if (s.length() < 10) return new ArrayList<>();
        Set<String> res = new HashSet<>();
        Set<Integer> set = new HashSet<>();
        Map<Character, Integer> map = new HashMap<>();
        map.put('A', 0);
        map.put('C', 1);
        map.put('G', 2);
        map.put('T', 3);

        int val = 0, mask = 0;
        for (int i = 0; i < 10; i++) {
            val = (val << 2) + map.get(s.charAt(i));
            mask = (mask << 2) + 3;
        }
        set.add(val);

        for (int i = 10; i < s.length(); i++) {
            val = ((val << 2) & mask) + map.get(s.charAt(i));
            if (set.contains(val)) {
                res.add(s.substring(i - 10 + 1, i + 1));
            } else {
                set.add(val);
            }
        }

        return new ArrayList<String>(res);
    }
}