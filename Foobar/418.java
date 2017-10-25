class Solution {
    public int wordsTyping(String[] sentence, int rows, int cols) {
        int len = sentence.length;
        int[] curLineReps = new int[len];
        int[] nextLineStart = new int[len];

        for (int i = 0; i < len; i++) {
            int curLen = 0, reps = 0, j = i;
            while (curLen + sentence[j].length() <= cols) {
                curLen += sentence[j++].length() + 1;
                if (j == len) {
                    j = 0;
                    reps++;
                }
            }

            curLineReps[i] = reps;
            nextLineStart[i] = j;
        }

        int ret = 0;
        for (int i = 0, j = 0; i < rows; i++) {
            ret += curLineReps[j];
            j = nextLineStart[j];
        }

        return ret;
    }
}