class Solution {
    public int[] numberOfLines(int[] widths, String S) {
        int curLine = 0, cnt = 1;
        for (char ch : S.toCharArray()) {
            int w = widths[ch - 'a'];
            if (curLine + w > 100) {
                cnt++;
                curLine = 0;
            }

            curLine += w;
        }

        return new int[]{cnt, curLine};
    }
}