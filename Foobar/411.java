class Solution {
    public String minAbbreviation(String target, String[] dictionary) {
        Set<Integer> dict = new HashSet<>();
        int cand = 0;
        int len = target.length();

        for (String word : dictionary) {
            if (word.length() != len) continue;
            int w = 0;
            for (int i = word.length()-1, bit=1; i >= 0; i--, bit <<= 1) {
                if (target.charAt(i) != word.charAt(i)) {
                    w += bit;
                }
                //System.out.println(Integer.toBinaryString(w));
            }
            System.out.println(Integer.toBinaryString(w));
            dict.add(w);
            cand |= w;
        }
        
        System.out.println(Integer.toBinaryString(cand));

        bt(1, 0, dict, cand, len);
        
        System.out.println(Integer.toBinaryString(minAbbr));

        StringBuilder sb = new StringBuilder();
        int zero = 0;
        for (int i = 0; i < len; i++) {
            if (((minAbbr>>i) & 1) == 1) {
                if (zero > 0) sb.insert(0, zero);
                sb.insert(0, target.charAt(len-1-i));
                zero = 0;
            } else {
                zero++;
            }
        }
        if (zero != 0) sb.insert(0, zero);

        return sb.toString();
    }

    int minAbbrLen = Integer.MAX_VALUE, minAbbr;
    private void bt(int bit, int mask, Set<Integer> dict, int cand, int len) {
        int l = abLen(mask, len);
        if (l >= minAbbrLen) return;
        boolean match = false;
        for (int d : dict) {
            match |= ((d & mask) == 0);
            if (match) break;
        }

        if (!match) {
            minAbbrLen = l;
            minAbbr = mask;
        } else {
            for (int i = bit; i <= (1 << len); i <<= 1) {
                if ((cand & i) != 0) bt(i << 1, (mask | i), dict, cand, len);
            }
        }
    }

    private int abLen(int mask, int len) {
        int l = 0, p = 1;
        for (int i = 0; i < len; i++) {
            if (((mask>>i) & 1) == 1) {
                l++;
                p = 1;
            } else {
                if (p == 1) l++;
                p = 0;
            }
        }
        return l;
    }
}
