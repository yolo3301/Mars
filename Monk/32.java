public class Solution {
    public int longestValidParentheses(String s) {
        if (s.length() == 0) return 0;
        Stack<int[]> stack = new Stack<>();
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(new int[] {i, 0});
            } else {
                if (!stack.empty() && stack.peek()[1] == 0) {
                    stack.pop();
                    res = Math.max(res, i - (stack.empty() ? -1 : stack.peek()[0]));
                } else {
                    stack.push(new int[] {i, 1});
                }
            }
        }

        return res;
    }
}