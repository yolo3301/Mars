// There is a DP solution too.
public class Solution {
    public int longestValidParentheses(String s) {
        if (s.isEmpty()) return 0;

        int len = s.length(), res = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                if (!stack.empty() && s.charAt(stack.peek()) == '(') {
                    stack.pop();
                } else {
                    stack.push(i);
                }
            }
        }

        if (stack.empty()) return len;

        int j = len, k = 0;
        while (!stack.empty()) {
            k = stack.pop();
            res = Math.max(res, j - k - 1);
            j = k;
        }
        res = Math.max(res, j);

        return res;
    }
}
