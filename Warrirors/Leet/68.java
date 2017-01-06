public class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        if (words.length == 0) return res;
        if (maxWidth == 0) {
            res.add("");
            return res;
        }

        int i = 0;
        while (i < words.length) {
            int j = i - 1;
            int widthNeeded = 0;
            int wlen = 0;
            do {
                j++;
                if (j >= words.length) break;
                wlen += words[j].length();
                widthNeeded += words[j].length() + ((j == i) ? 0 : 1);
            } while (widthNeeded <= maxWidth);

            if (j == words.length) {
                StringBuilder sb = new StringBuilder(words[i]);
                for (int k = i + 1; k < j; k++) {
                    sb.append(' ').append(words[k]);
                }
                while (sb.length() < maxWidth) sb.append(' ');
                res.add(sb.toString());
            } else {
                wlen -= words[j].length();
                int spaces = maxWidth - wlen;
                int intervals = j - i - 1;

                System.out.println("spaces:" + spaces + "  intervals:" + intervals);

                if (intervals == 0) {
                    char[] temp = new char[spaces];
                    Arrays.fill(temp, ' ');
                    String avgSpace = new String(temp);
                    res.add(words[i] + avgSpace);
                } else {
                    int avgSpaces = spaces / intervals;
                    int leftSpaces = spaces % intervals;

                    char[] temp = new char[avgSpaces];
                    Arrays.fill(temp, ' ');
                    String avgSpace = new String(temp);

                    StringBuilder sb = new StringBuilder(words[i]);
                    for (int k = i + 1; k < j; k++) {
                        sb.append(avgSpace);
                        if (leftSpaces > 0) {
                            sb.append(' ');
                            leftSpaces--;
                        }
                        sb.append(words[k]);
                    }
                    res.add(sb.toString());
                }
            }

            i = j;
        }

        return res;
    }
}
