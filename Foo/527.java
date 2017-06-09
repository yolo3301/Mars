public class Solution {
    public List<String> wordsAbbreviation(List<String> dict) {
        int len = dict.size();
        String[] res = new String[len];
        int[] prefix = new int[len];

        for (int i = 0; i < len; i++) {
            prefix[i] = 1;
            res[i] = abbr(dict.get(i), 1);
        }

        for (int i = 0; i < len; i++) {
            while (true) {
                // optimization can be done here
                Set<Integer> set = new HashSet<>();
                for (int j = i+1; j < len; j++) {
                    if (res[i].equals(res[j]))
                        set.add(j);
                }

                if (set.isEmpty()) break;
                set.add(i);

                for (int k : set) {
                    res[k] = abbr(dict.get(k), ++prefix[k]);
                }
            }
        }

        return Arrays.asList(res);
    }

    private String abbr(String str, int prefix) {
        if (prefix >= str.length() - 2) return str;
        StringBuilder sb = new StringBuilder();
        sb.append(str.substring(0, prefix));
        sb.append(str.length() - prefix - 1);
        sb.append(str.charAt(str.length() - 1));
        return sb.toString();
    }
}