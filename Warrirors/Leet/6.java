public class Solution {
    public String convert(String s, int numRows) {
        if (s.length() == 0 || numRows == 1) return s;
        StringBuilder sb = new StringBuilder();
        int basediff = 2 * numRows - 2;
        int diff = 2 * numRows - 2;
        for (int i = 0; i < numRows; i++) {
            int j = i;
            while (j < s.length()) {
                sb.append(s.charAt(j));
                if (i != 0 && i != numRows - 1 && j + diff < s.length()) {
                    sb.append(s.charAt(j + diff));
                }
                j += basediff;
            }
            diff -= 2;
        }

        return sb.toString();
    }
}
