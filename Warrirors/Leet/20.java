public class Solution {
    public boolean isValid(String s) {
        if (s == null || s.length() == 0) return true;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '{' || ch == '[' || ch == '(') {
                stack.push(ch);
            } else if (ch == '}') {
                if (!stack.empty() && stack.peek() == '{')
                    stack.pop();
                else
                    return false;
            } else if (ch == ']') {
                if (!stack.empty() && stack.peek() == '[') 
                    stack.pop();
                else
                    return false;
            } else {
                if (!stack.empty() && stack.peek() == '(')
                    stack.pop();
                else
                    return false;
            }
        }
        return stack.empty();
    }
}
