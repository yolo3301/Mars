public class Solution {
    public String removeKdigits(String num, int k) {
        if (k == 0) return num;

        Stack<Character> s = new Stack<>();
        for (char i : num.toCharArray()) {
            while (k > 0 && !s.empty() && i < s.peek()) {
                s.pop();
                k--;
            }
            s.push(i);
        }
        
        while (k > 0 && !s.empty()) {
            s.pop();
            k--;
        }

        StringBuilder sb = new StringBuilder();
        while (!s.empty()) {
            sb.insert(0, s.pop());
        }

        while (sb.length() > 0 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }
        
        if (sb.length() == 0) return "0";

        return sb.toString();
    }
}