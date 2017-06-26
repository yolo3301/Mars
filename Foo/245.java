public class Solution {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        if (word1.equals(word2)) return shortestDistance2(words, word1);
        else return shortestDistance1(words, word1, word2);
    }

    private int shortestDistance1(String[] words, String word1, String word2) {
        int res = Integer.MAX_VALUE, j = -1, k = -1;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                j = i;
            }
            if (words[i].equals(word2)) {
                k = i;
            }

            if (j >= 0 && k >= 0) {
                res = Math.min(res, Math.abs(j-k));
            }
        }

        return res;
    }

    private int shortestDistance2(String[] words, String w) {
        int res = Integer.MAX_VALUE, j = -1;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(w)) {
                if (j >= 0) res = Math.min(res, i - j);
                j = i;
            }
        }
        return res;
    }
}