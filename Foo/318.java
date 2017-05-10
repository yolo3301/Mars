public class Solution {
    public int maxProduct(String[] words) {
        if (words.length < 2) return 0;
        Arrays.sort(words, (a, b) -> {
            return b.length() - a.length();
        });

        int[] map = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            map[i] = cal(words[i]);
        }

        int res = 0;
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() * words[i].length() <= res) break;
            for (int j = i+1; j < words.length; j++) {
                if ((map[i] & map[j]) == 0) {
                    res = Math.max(res, words[i].length() * words[j].length());
                    break;
                }
            }
        }

        return res;
    }

    private int cal(String s) {
        int res = 0;
        for (char ch : s.toCharArray()) {
            res |= (1 << (ch - 'a'));
        }
        return res;
    }
}