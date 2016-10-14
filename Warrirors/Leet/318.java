public class Solution {
    public int maxProduct(String[] words) {
        if (words == null || words.length < 2) return 0;

        Arrays.sort(words, new Comparator<String>() {
            public int compare(String a, String b) {
                return b.length() - a.length();
            }
        });

        int[] mask = new int[words.length];

        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                mask[i] |= 1 << (words[i].charAt(j) - 'a');
            }
        }

        int res = 0;
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() * words[i].length() <= res) break;
            for (int j = i + 1; j < words.length; j++) {
                int curr = words[i].length() * words[j].length();
                if ((mask[i] & mask[j]) == 0 && curr > res) {
                    res = curr;
                    break;
                }
            }
        }

        return res;
    }
}
