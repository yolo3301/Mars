public class Solution {
    public String countAndSay(int n) {
        String s = "1";
        for (int i = 1; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            int j = 0;
            while (j < s.length()) {
                char curr = s.charAt(j);
                int count = 0;
                while (j < s.length() && s.charAt(j) == curr) {
                    j++;
                    count++;
                }
                sb.append(count);
                sb.append(curr);
            }
            s = sb.toString();
        }

        return s;
    }
}
