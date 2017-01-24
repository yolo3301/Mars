public class Solution {
    public String licenseKeyFormatting(String S, int K) {
        S = S.toUpperCase();
        S = S.replaceAll("-", "");

        StringBuilder sb = new StringBuilder();

        int j = 0;
        for (int i = S.length() - 1; i >= 0; i--) {
            j++;
            sb.append(S.charAt(i));
            if (j == K && i > 0) {
                sb.append('-');
                j = 0;
            }
        }

        return sb.reverse().toString();
    }
}
