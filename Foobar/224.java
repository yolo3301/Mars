class Solution {
    public int calculate(String s) {
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') continue;
            if (s.charAt(i) == '+') {
                stack.push("+");
            } else if (s.charAt(i) == '-') {
                stack.push("-");
            } else if (s.charAt(i) == '(') {
                stack.push("(");
            } else if (s.charAt(i) == ')') {
                updateStack(stack);
            } else {
                int j = i;
                while (j < s.length() && Character.isDigit(s.charAt(j))) {
                    j++;
                }
                stack.push(s.substring(i, j));
                i = j-1;
            }
        }

        updateStack(stack);

        return Integer.valueOf(stack.pop());
    }

    private void updateStack(Stack<String> stack) {
        int last = 0;
        int val = 0;
        while (!stack.empty()) {
            String cur = stack.pop();
            if (cur.equals("+")) continue;
            else if (cur.equals("-")) val -= 2*last;
            else if (cur.equals("(")) break;
            else {
                int curVal = Integer.valueOf(cur);
                val += curVal;
                last = curVal;
            }
        }
        stack.push(Integer.toString(val));
    }
}