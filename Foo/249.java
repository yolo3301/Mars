public class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> res = new ArrayList<>();
        if (strings.length == 0) return res;

        Map<String, List<String>> map = new HashMap<>();
        for (String str : strings) {
            String key = getKey(str);
            if (!map.containsKey(key)) map.put(key, new ArrayList<>());
            map.get(key).add(str);
        }

        for (String k : map.keySet()) {
            res.add(map.get(k));
        }

        return res;
    }

    private String getKey(String str) {
        int shift = str.charAt(0) - 'a';
        StringBuilder sb = new StringBuilder();
        for (char ch : str.toCharArray()) {
            sb.append(getAlter(ch, shift));
        }

        return sb.toString();
    }

    private char getAlter(char ch, int shift) {
        if (ch - shift >= 'a') {
            return (char)(ch - shift);
        }

        return (char)(ch + 26 - shift);
    }
}