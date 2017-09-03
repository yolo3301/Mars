class Solution {
    public int maximumSwap(int num) {
        char[] chs = Integer.toString(num).toCharArray();

        // Record the last index of each digit.
        int[] pos = new int[10];
        for (int i = 0; i < chs.length; i++) {
            pos[chs[i]-'0'] = i;
        }

        for (int i = 0; i < chs.length; i++) {
            int v = chs[i] - '0';
            // If any larger one is after the current, just use that
            for (int j = 9; j > v; j--) {
                if (pos[j] > i) {
                    chs[pos[j]] = chs[i];
                    chs[i] = (char)('0' + j);
                    return Integer.parseInt(new String(chs));
                }
            }
        }

        return num;
    }
}