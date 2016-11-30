public class Solution {
    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            // special handle when l == 0
            int l = n % 26;
            char curr = l == 0 ? 'Z' : (char)('A' - 1 + l);
            sb.append(curr);
            n /= 26;
            if (l == 0) n--;
        }

        return sb.reverse().toString();
    }
}
