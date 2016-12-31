public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        if (strs.length == 0) return res;
        HashMap<HashMap<Character, Integer>, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            HashMap<Character, Integer> curr = count(strs[i]);
            if (!map.containsKey(curr)) {
                map.put(curr, new ArrayList<String>());
            }
            map.get(curr).add(strs[i]);
        }

        return new ArrayList<List<String>>(map.values());
    }

    private HashMap<Character, Integer> count(String s) {
        HashMap<Character, Integer> res = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (res.containsKey(c)) {
                res.put(c, res.get(c) + 1);
            } else {
                res.put(c, 1);
            }
        }
        return res;
    }
}


public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) return new ArrayList<List<String>>();
        HashMap<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] curr = strs[i].toCharArray();
            Arrays.sort(curr);
            String sc = new String(curr);
            if (!map.containsKey(sc)) {
                map.put(sc, new ArrayList<String>());
            }
            map.get(sc).add(strs[i]);
        }
        return new ArrayList<List<String>>(map.values());
    }
}
