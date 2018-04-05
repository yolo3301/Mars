class Solution {
    public int expressiveWords(String S, String[] words) {
        List<int[]> target = parse(S);

        int ret = 0;
        for (String w : words) {
            List<int[]> cur = parse(w);

            if (cur.size() != target.size())
                continue;

            boolean match = true;
            for (int j = 0; j < target.size(); j++) {
                if (cur.get(j)[0] != target.get(j)[0]
                    || cur.get(j)[1] > target.get(j)[1]) {
                    match = false;
                    break;
                }

                if (target.get(j)[1] <= 2 && cur.get(j)[1] != target.get(j)[1]) {
                    match = false;
                    break;
                }
            }

            if (match) ret++;
        }

        return ret;
    }

    private List<int[]> parse(String w) {
        List<int[]> ret = new ArrayList<>();
        for (int i = 0; i < w.length(); ) {
            int j = i;
            while (j < w.length() && w.charAt(j) == w.charAt(i))
                j++;
            
            ret.add(new int[]{w.charAt(i) - 'a', j - i});

            i = j;
        }

        return ret;
    }
}