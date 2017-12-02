class Solution {
    public int maxProduct(String[] words) {
        if (words.length < 2) return 0;
        Arrays.sort(words, (a, b) -> {
            return b.length() - a.length();
        });

        int[] hash = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            hash[i] = cal(words[i]);
        }

        int ret = 0;
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() * words[i].length() <= ret) break;
            for (int j = i+1; j < words.length; j++) {
                if ((hash[i] & hash[j]) == 0) {
                    ret = Math.max(ret, words[i].length() * words[j].length());
                    break;
                }
            }
        }

        return ret;
    }

    private int cal(String word) {
        int ret = 0;
        for (char ch : word.toCharArray()) {
            ret |= (1 << (ch - 'a'));
        }
        return ret;
    }
}