public class Solution {
    public String decodeString(String s) {
        if (s == null || s.length() == 0) return s;
        Stack<String> stack = new Stack<>();
        int i = 0;
        while (i < s.length()) {
            if (s.charAt(i) == '[') {
                stack.push("[");
                i++;
            } else if (s.charAt(i) == ']') {
                StringBuilder sb = new StringBuilder();
                while (!stack.empty() && stack.peek() != "[") {
                    sb.insert(0, stack.pop());
                }
                stack.pop(); // pop [
                int rep = Integer.parseInt(stack.pop());
                String tmp = sb.toString();
                for (int k = 0; k < rep - 1; k++) {
                    sb.append(tmp);
                }
                stack.push(sb.toString());
                i++;
            } else {
                int j = i;
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    i++;
                }
                if (i < s.length() && !Character.isDigit(s.charAt(i)) && s.charAt(i) != '[' && s.charAt(i) != ']') {
                    i++;
                }
                if (i > j) {
                    // it's a number
                    stack.push(s.substring(j, i));
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.empty()) {
            sb.insert(0, stack.pop());
        }

        return sb.toString();
    }
}
