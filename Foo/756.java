class Solution {
    public boolean pyramidTransition(String bottom, List<String> allowed) {
        Map<String, List<String>> index = new HashMap<>();
        for (String str : allowed) {
            String key = str.substring(0, 2);
            String value = str.substring(2);
            if (!index.containsKey(key)) index.put(key, new ArrayList<>());
            index.get(key).add(value);
        }

        return bt(bottom, "", 0, index);
    }

    private boolean bt(String lastRow, String curRow, int index, Map<String, List<String>> allowed) {
        if (lastRow.length() == 1) return true;
        if (index == lastRow.length()-1) {
            return bt(curRow, "", 0, allowed);
        }

        String key = lastRow.substring(index, index+2);
        if (!allowed.containsKey(key)) return false;

        for (String cand : allowed.get(key)) {
            if (bt(lastRow, curRow+cand, index+1, allowed))
                return true;
        }

        return false;
    }
}