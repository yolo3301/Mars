// Faster solution
// https://discuss.leetcode.com/topic/15816/iterative-java-solution-with-stack
public class Solution {
    public int calculate(String s) {
        Deque<String> nums = new LinkedList<>();
        Deque<Character> ops = new LinkedList<>();
        char[] chs = s.toCharArray();
        int res = 0;
        for (int i = 0; i < chs.length; i++) {
            char curr = chs[i];
            if (curr == '+' || curr == '-') {
                ops.addLast(curr);
            } else if (curr == ' ') {
                continue;
            } else if (Character.isDigit(curr)) {
                int j = i;
                while (j < chs.length && Character.isDigit(chs[j])) {
                    j++;
                }
                String n = s.substring(i, j);
                nums.addLast(n);
                i = j - 1;
            } else if (curr == '(') {
                nums.addLast("(");
            } else if (curr == ')') {
                int c = 0;
                Deque<String> tns = new LinkedList<>();
                Deque<Character> tops = new LinkedList<>();
                while (!nums.isEmpty() && !nums.peekLast().equals("(")) {
                    tns.addFirst(nums.removeLast());
                    c++;
                }
                if (!nums.isEmpty()) nums.removeLast();
                for (int k = 0; k < c - 1; k++) tops.addFirst(ops.removeLast());
                nums.addLast(cal(tns, tops));
            }
        }

        return Integer.valueOf(cal(nums, ops));
    }

    private String cal(Deque<String> nums, Deque<Character> ops) {
        while (!ops.isEmpty()) {
            int v1 = Integer.valueOf(nums.removeFirst());
            int v2 = Integer.valueOf(nums.removeFirst());
            char op = ops.removeFirst();

            if (op == '+') {
                nums.addFirst(Integer.toString(v1 + v2));
            } else {
                nums.addFirst(Integer.toString(v1 - v2));
            }
        }

        return nums.removeFirst();
    }
}
