public class Solution {
    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        while (n != 0) {
            int x = n % 26;
            n /= 26;
            if (x == 0) {
                sb.append('Z');
                n--;
            } else {
                sb.append((char)('A' + x - 1));
            }
        }

        return sb.reverse().toString();
    }
}