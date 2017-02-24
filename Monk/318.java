public class Solution {
    public int maxProduct(String[] words) {
        if (words.length < 2) return 0;
        Arrays.sort(words, new Comparator<String>() {
            public int compare(String s1, String s2) {
                return s2.length() - s1.length();
            }
        });

        int[] mask = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            for (char ch : words[i].toCharArray()) {
                mask[i] |= (1 << ch - 'a');
            }
        }

        int res = 0;
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() * words[i].length() <= res) break;
            for (int j = i + 1; j < words.length; j++) {
                if ((mask[i] & mask[j]) == 0) {
                    res = Math.max(res, words[i].length() * words[j].length());
                    break;
                }
            }
        }

        return res;
    }
}