public class Solution {
    public int wordsTyping(String[] sentence, int rows, int cols) {
        int[] nextIndex = new int[sentence.length]; // record the start index on the next line given the start index of the current line
        int[] reps = new int[sentence.length]; // record given the start index, how many time the sentence repeats in the current line
        for (int i = 0; i < sentence.length; i++) {
            int len = 0, j = i, r = 0; // j = i because the current start index is i, r is repeats
            while (len + sentence[j].length() <= cols) {
                len += sentence[j].length() + 1;
                j++;
                if (j == sentence.length) {
                    r++;
                    j = 0;
                }
            }

            nextIndex[i] = j;
            reps[i] = r;
        }

        // for each line, accumulates
        int res = 0, nextStartIndex = 0;
        for (int i = 0; i < rows; i++) {
            res += reps[nextStartIndex];
            nextStartIndex = nextIndex[nextStartIndex];
        }

        return res;
    }
}