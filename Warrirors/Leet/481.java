public class Solution {
    public int magicalString(int n) {
        if (n <= 0) return 0;
        if (n < 4) return 1;
        String magic = "122";
        int res = 1, newAdded = 1;

        while (magic.length() < n) {
            StringBuilder sb = new StringBuilder();
            char ch = (magic.charAt(magic.length() - 1) == '1') ? '2' : '1';
            for (int j = magic.length() - newAdded; j < magic.length(); j++) {
                int rep = magic.charAt(j) - '0';
                for (int k = 0; k < rep; k++) {
                    sb.append(ch);
                    if (ch == '1') res++;
                    if (magic.length() + sb.length() == n) break;
                }
                if (magic.length() + sb.length() == n) break;
                ch = (ch == '1') ? '2' : '1';
            }

            if (magic.length() + sb.length() == n) break;

            newAdded = sb.length();
            magic += sb.toString();
        }

        return res;
    }
}
