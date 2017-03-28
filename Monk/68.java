 public class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        if (words.length == 0) return res;
        if (maxWidth == 0) {
            res.add(words[0]);
            return res;
        }

        int i = 0;
        while (i < words.length) {
            int j = i, llen = 0;
            while (j < words.length && llen + words[j].length() + (j != i ? 1 : 0) <= maxWidth) {
                if (j != i) llen++;
                llen += words[j].length();
                j++;
            }

            StringBuilder sb = new StringBuilder();
            if (j != words.length && j - i > 1) {
                int wlen = llen - (j - i - 1);
                int slen = maxWidth - wlen;
                int even = slen / (j - i - 1);
                int more = slen % (j - i - 1);
                StringBuilder sp = new StringBuilder();
                for (int k = 0; k < even; k++) sp.append(' ');
                for (int k = i; k < j; k++) {
                    sb.append(words[k]);
                    if (k != j - 1) {
                        sb.append(sp.toString());
                        if (more-- > 0) sb.append(' ');
                    }
                }
            } else if (j - i == 1) {
                sb.append(words[i]);
                for (int k = 0; k < maxWidth - words[i].length(); k++) {
                    sb.append(' ');
                }
            } 
            else {
                for (int k = i; k < j; k++) {
                    sb.append(words[k]);
                    if (k != j - 1) {
                        sb.append(' ');
                    }
                }
                int tmp = sb.length();
                for (int k = 0; k < maxWidth - tmp; k++)
                    sb.append(' ');
            }

            res.add(sb.toString());

            i = j;
        }

        return res;
    }
}