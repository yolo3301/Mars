public class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        int slen = s.length();
        int wlen = words[0].length();
        int tlen = wlen * words.length;

        if (slen == 0 || words.length == 0 || tlen > slen) return res;

        Map<String, Integer> count = new HashMap<>();
        for (String w : words) {
            count.put(w, count.getOrDefault(w, 0) + 1);
        }

        for (int k = 0; k < wlen; k++) {
            Map<String, Integer> window = new HashMap<>();
            for (int i = k, j = k, wc = 0; i + wlen <= slen; i += wlen) {
                String curr = s.substring(i, i + wlen);
                if (!count.containsKey(curr)) {
                    j = i + wlen;
                    window.clear();
                    wc = 0;
                } else {
                    int c = window.getOrDefault(curr, 0);
                    window.put(curr, c + 1);
                    wc++;
                    if (c >= count.get(curr)) {
                        while (j < i && window.get(curr) > count.get(curr)) {
                            String prev = s.substring(j, j + wlen);
                            window.put(prev, window.get(prev) - 1);
                            wc--;
                            j += wlen;
                        }
                    }
                }
                if (wc == words.length) {
                    res.add(j);
                }
            }
        }

        return res;
    }
}