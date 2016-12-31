// https://discuss.leetcode.com/topic/17435/java-straight-forward-iteration-solution-with-comments-no-stack-o-n-o-1
// Seems there is a better solution
public class Solution {
    public int calculate(String s) {
        Deque<Integer> nums = new LinkedList<>();
        Deque<Character> ops = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (Character.isDigit(ch)) {
                sb.append(ch);
            } else {
                if (sb.length() > 0) {
                    int val = Integer.valueOf(sb.toString());
                    sb = new StringBuilder();
                    if (!ops.isEmpty() && (ops.peekLast().equals('*') || ops.peekLast().equals('/'))) {
                        char op = ops.removeLast();
                        int last = nums.removeLast();
                        val = cal(last, val, op);
                    }
                    nums.addLast(val);
                }

                if (!Character.isSpace(ch)) {
                    ops.addLast(ch);
                }
            }
        }

        if (sb.length() > 0) {
            int val = Integer.valueOf(sb.toString());
            sb = new StringBuilder();
            if (!ops.isEmpty() && (ops.peekLast().equals('*') || ops.peekLast().equals('/'))) {
                char op = ops.removeLast();
                int last = nums.removeLast();
                val = cal(last, val, op);
            }
            nums.addLast(val);
        }

        while (!ops.isEmpty()) {
            int v1 = nums.removeFirst();
            int v2 = nums.removeFirst();
            char op = ops.removeFirst();
            nums.push(cal(v1, v2, op));
        }

        return nums.pop();
    }

    private int cal(int v1, int v2, char op) {
        if (op == '+') {
            return v1 + v2;
        } else if (op == '-') {
            return v1 - v2;
        } else if (op == '*') {
            return v1 * v2;
        } else {
            return v1 / v2;
        }
    }
}
