public class Solution {
    int n, bn, cand, minlen, minab;
    Set<Integer> set = new HashSet<>();
    public String minAbbreviation(String target, String[] dictionary) {
        n = target.length();
        bn = 1 << n;
        cand = 0;
        minlen = Integer.MAX_VALUE;

        for (String str : dictionary) {
            if (str.length() != n) continue;
            int word = 0;

            for (int i = n-1, bit = 1; i >= 0; --i, bit <<= 1)
                if (target.charAt(i) != str.charAt(i)) word += bit;

            // word -- 1 means the bit is diff from target, 0 means the same
            set.add(word);
            cand |= word;
        }

        // starting from 1st bit and mask = 0
        bt(1, 0);
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; ) {
            if ((minab & 1) != 0) {
                sb.insert(0, target.charAt(n-i-1));
                minab >>= 1;
                i++;
            } else {
                int j = i;
                while ((minab & 1) == 0 && j < n) {
                    j++;
                    minab >>= 1;
                }
                sb.insert(0, j-i);
                i = j;
            }
        }

        return sb.toString();
    }

    private void bt(int bit, int mask) {
        int len = abLen(mask);
        if (len >= minlen) return;

        boolean match = true;
        for (int word : set) {
            // == 0 means the mask didn't select any diff bit
            // which means there will be ambigiouty
            if ((word & mask) == 0) {
                match = false;
                break;
            }
        }

        if (match) {
            minlen = len;
            minab = mask;
        } else {
            // Find the next bit to set in mask
            // must be a possible diff bit
            for (int i = bit; i < bn; i <<= 1) {
                if ((cand & i) != 0) {
                    bt(i << 1, mask + i);
                }
            }
        }
    }

    private int abLen(int mask) {
        int len = 0;
        for (int i = 0; i < n; ) {
            if ((mask & 1) != 0) {
                mask >>= 1;
                i++;
            } else {
                while ((mask & 1) == 0 && i < n) {
                    i++;
                    mask >>= 1;
                }
            }
            len++;
        }

        return len;
    }
}