public class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if (s.isEmpty() || words.length == 0) return res;

        int wlen = words[0].length();
        int tlen = wlen * words.length;
        int slen = s.length();

        if (slen < tlen) return res;

        Map<String, Integer> count = new HashMap<>();
        for (String w : words) {
            if (count.containsKey(w)) {
                count.put(w, count.get(w) + 1);
            } else {
                count.put(w, 1);
            }
        }

        for (int i = 0; i < wlen; i++) {
            int k = i;
            int c = 0;
            Map<String, Integer> temp = new HashMap<>();
            for (int j = i; j + wlen <= slen; j += wlen) {
                if (count.containsKey(curr)) {
                    if (temp.containsKey(curr)) {
                        temp.put(curr, temp.get(curr) + 1);
                    } else {
                        temp.put(curr, 1);
                    }
                    c++;

                    // need to remove until meet requirement
                    while (temp.get(curr) > count.get(curr)) {
                        String hw = s.substring(k, k + wlen);
                        if (temp.get(hw) == 1) temp.remove(hw);
                        else temp.put(hw, temp.get(hw) - 1);
                        k += wlen;
                        c--;
                    }

                    if (c == words.length) {
                        res.add(k);
                        // remove one at head
                        String hw = s.substring(k, k + wlen);
                        if (temp.get(hw) == 1) temp.remove(hw);
                        else temp.put(hw, temp.get(hw) - 1);
                        k += wlen;
                        c--;
                    }
                } else {
                    k = j + wlen;
                    temp = new HashMap<>();
                    c= 0;
                }
            }
        }

        return res;
    }
}
