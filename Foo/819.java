class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        Map<String, Integer> cnt = new HashMap<>();
        Set<String> b = new HashSet<>();

        for (String w : banned) {
            b.add(w);
        }

        for (int i = 0; i < paragraph.length(); ) {
            int j = i;
            while (j < paragraph.length() && Character.isLetter(paragraph.charAt(j))) {
                j++;
            }

            if (i == j) {
                i++;
                continue;
            }

            String w = paragraph.substring(i, j).toLowerCase();
            if (!b.contains(w)) {
                cnt.put(w, cnt.getOrDefault(w, 0) + 1);
            }
            
            i = j;
        }

        int max = 0;
        String ret = null;

        for (Map.Entry<String, Integer> e : cnt.entrySet()) {
            if (e.getValue() > max) {
                max = e.getValue();
                ret = e.getKey();
            }
        }

        return ret;
    }
}