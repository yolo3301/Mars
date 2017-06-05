public class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        int i = 0, j = 0;
        while (i < abbr.length()) {
            if (Character.isLetter(abbr.charAt(i))) {
                if (j < word.length() && abbr.charAt(i) == word.charAt(j)) {
                    i++;
                    j++;
                } else {
                    return false;
                }
            } else {
                int k = i;
                while (k < abbr.length() && Character.isDigit(abbr.charAt(k)))
                    k++;
                int cnt = Integer.valueOf(abbr.substring(i, k));

                if (!Integer.toString(cnt).equals(abbr.substring(i, k)) || cnt == 0)
                    return false;

                i = k;
                j += cnt;

                if (j > word.length()) return false;
            }
        }
        
        if (j < word.length()) return false;

        return true;
    }
}