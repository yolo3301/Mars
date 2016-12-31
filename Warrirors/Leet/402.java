public class Solution {
    public String removeKdigits(String num, int k) {
        if (k >= num.length()) return "0";
        if (k == 0) return num;

        // Every pop from the stack is a number to delete
        Stack<Character> s = new Stack<>();
        for (int i = 0; i < num.length(); i++) {
            char c = num.charAt(i);
            while (k > 0 && !s.empty() && s.peek() > c) {
                s.pop();
                k--;
            }
            s.push(c);
        }

        while (k > 0 && !s.empty()) {
            s.pop();
            k--;
        }

        StringBuilder sb = new StringBuilder();
        while (!s.empty()) {
            sb.append(s.pop());
        }
        sb.reverse();

        while (sb.length() > 1 && sb.charAt(0) == '0')
            sb.deleteCharAt(0);

        return sb.toString();
    }
}
