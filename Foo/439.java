public class Solution {
    public String parseTernary(String expression) {
        Stack<Character> stack = new Stack<>();
        for (int j = expression.length()-1; j >= 0; j--) {
            char curr = expression.charAt(j);
            if (curr == ':') {
                continue;
            } else if (curr == '?') {
                char flag = expression.charAt(--j);
                boolean isTrue = (flag == 'T');
                if (isTrue) {
                    char temp = stack.pop();
                    stack.pop();
                    stack.push(temp);
                } else {
                    stack.pop();
                }
            } else {
                stack.push(curr);
            }
        }

        return Character.toString(stack.pop());
    }
}