class Solution {
    public int countBinarySubstrings(String s) {
        int ret = 0;
        if (s.length() <= 1) return ret;

        char prevCh = s.charAt(0);
        int j = 0;
        while (j < s.length() && s.charAt(j) == prevCh) j++;
        int prevSize = j;

        for (int i = j; i < s.length(); ) {
            char curCh = s.charAt(i);
            int k = i;
            while (k < s.length() && s.charAt(k) == curCh) k++;
            int curSize = k - i;

            ret += Math.min(curSize, prevSize);

            i = k;
            prevSize = curSize;
        }

        return ret;
    }
}