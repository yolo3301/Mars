class Solution {
    public int wordsTyping(String[] sentence, int rows, int cols) {
        int[] nextLineStart = new int[sentence.length];
        int[] currLineReps = new int[sentence.length];
        for (int i = 0; i < sentence.length; i++) {
            int len = 0, j = i, r = 0;
            while (len + sentence[j].length() <= cols) {
                len += sentence[j++].length() + 1;
                if (j == sentence.length) {
                    j = 0;
                    r++;
                }
            }

            nextLineStart[i] = j;
            currLineReps[i] = r;
        }

        int res = 0, lineStart = 0;
        for (int i = 0; i < rows; i++) {
            res += currLineReps[lineStart];
            lineStart = nextLineStart[lineStart];
        }

        return res;
    }
}