public class Solution {
    public String removeKdigits(String num, int k) {
        if (k == num.length()) return "0";

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < num.length(); i++) {
            int curr = num.charAt(i) - '0';
            while (!stack.empty() && stack.peek() > curr && k > 0) {
                stack.pop();
                k--;
            }
            stack.push(curr);
        }

        while (k-- > 0) stack.pop();

        StringBuilder sb = new StringBuilder();
        while (!stack.empty()) {
            sb.insert(0, stack.pop());
        }
        while (sb.length() > 0 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }

        if (sb.length() == 0) return "0";
        return sb.toString();
    }
}