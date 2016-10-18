public class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> res = new ArrayList<>();
        bt(new Stack<Integer>(), new Stack<String>(), 0, input.split("(?<=\\D)(?=\\d)|(?<=\\d)(?=\\D)"), res);
        return res;
    }

    private void bt(Stack<Integer> s1, Stack<String> s2, int index, String[] parts, List<Integer> result) {
        if (index >= parts.length) {
            Stack<Integer> sc1 = (Stack<Integer>)s1.clone();
            Stack<String> sc2 = (Stack<String>)s2.clone();

            while (!sc2.empty()) {
                sc1.push(calTop(sc1, sc2));
            }
            result.add(sc1.pop());
            return;
        }

        if (index == 0) {
            int first = Integer.valueOf(parts[0]);
            s1.push(first);
            bt(s1, s2, index + 1, parts, result);
        } else {
            // option 1, direct add
            String op = parts[index];
            int num = Integer.valueOf(parts[index + 1]);
            s1.push(num);
            s2.push(op);
            bt(s1, s2, index + 2, parts, result);
            // clean up
            s1.pop();
            s2.pop();

            // option 2, cal right now
            if (!s2.empty()) {
                String op1 = s2.pop();
                int num1 = s1.pop();
                int num2 = s1.pop();
                s1.push(cal(num2, num1, op1));
                bt(s1, s2, index, parts, result);
                // clean up
                s1.pop();
                s1.push(num2);
                s1.push(num1);
                s2.push(op1);
            }
        }
    }

    private int calTop(Stack<Integer> s1, Stack<String> s2) {
        String op = s2.pop();
        int n1 = s1.pop();
        int n2 = s1.pop();

        return cal(n2, n1, op);
    }

    private int cal(int n1, int n2, String op) {
        if (op.equals("*")) {
            return n1 * n2;
        } else if (op.equals("+")) {
            return n1 + n2;
        } else {
            return n1 - n2;
        }
    }
}
