class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> ret = new ArrayList<>();
        if (words.length == 0) return ret;

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) map.put(words[i], i);

        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j <= words[i].length(); j++) {
                String s1 = words[i].substring(0, j);
                String s2 = words[i].substring(j);

                if (isPan(s1)) {
                    String rs2 = new StringBuilder(s2).reverse().toString();
                    if (map.containsKey(rs2) && i != map.get(rs2)) {
                        ret.add(Arrays.asList(map.get(rs2), i));
                    }
                }

                // Check s2 len to avoid duplicates
                if (s2.length() > 0 && isPan(s2)) {
                    String rs1 = new StringBuilder(s1).reverse().toString();
                    if (map.containsKey(rs1) && i != map.get(rs1)) {
                        ret.add(Arrays.asList(i, map.get(rs1)));
                    }
                }
            }
        }

        return ret;
    }

    private boolean isPan(String s) {
        int i = 0, j = s.length()-1;
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--))
                return false;
        }
        return true;
    }
}

