// http://www.matrix67.com/blog/archives/115
// https://tekmarathon.com/2013/05/14/algorithm-to-find-substring-in-a-string-kmp-algorithm/
public class KMP {
    public int[] preProcess(char[] pattern) {
        int len = pattern.length;
        int i = 0, j = -1;
        int[] b = new int[len+1];
        b[i] = j;

        while (i < len) {
            while (j >= 0 && pattern[i] != pattern[j]) {
                j = b[j];
            }
            i++;
            j++;
            b[i] = j;
        }

        return b;
    }

    public List<Integer> match(char[] text, char[] pattern) {
        List<Integer> res = new ArrayList<>();
        int[] b = preProcess(pattern);
        int i = 0, j = 0;

        while (i < text.length) {
            while (j >= 0 && pattern[j] != text[i]) {
                j = b[j];
            }

            i++;
            j++;
            if (j == pattern.length) {
                res.add(j - pattern.length);
                j = b[j];
            }
        }

        return res;
    }
}
