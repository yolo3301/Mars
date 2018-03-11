class Solution {
    public int numMatchingSubseq(String S, String[] words) {
        Map<Character, List<Integer>> index = new HashMap<>();
        for (int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);
            if (!index.containsKey(ch)) index.put(ch, new ArrayList<>());
            index.get(ch).add(i);
        }

        int ret = 0;
        for (String w : words) {
            if (isSub(index, w))
                ret++;
        }

        return ret;
    }

    private boolean isSub(Map<Character, List<Integer>> index, String w) {
        int cur = -1;
        for (char ch : w.toCharArray()) {
            if (!index.containsKey(ch)) return false;
            int t = nextGreater(index.get(ch), cur);
            if (t == -1) return false;
            cur = t;
        }
        return true;
    }

    private int nextGreater(List<Integer> index, int target) {
        int s = 0, e = index.size()-1;
        while (s <= e) {
            int m = s + (e - s) / 2;
            int v = index.get(m);
            if (v <= target) {
                s = m+1;
            } else {
                e = m;
                if (s == e) {
                    return index.get(m);
                }
            }
        }

        return -1;
    }
}