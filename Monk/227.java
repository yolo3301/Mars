public class Solution {
    public int calculate(String s) {
        Deque<Integer> nums = new LinkedList<>();
        Deque<Character> ops = new LinkedList<>();

        int i = 0;
        while (i < s.length()) {
            if (s.charAt(i) == '+' || s.charAt(i) == '-') {
                ops.addLast(s.charAt(i++));
            } else if (Character.isDigit(s.charAt(i))) {
                int j = i;
                while (j < s.length() && Character.isDigit(s.charAt(j))) {
                    j++;
                }

                int n = Integer.valueOf(s.substring(i, j));
                nums.addLast(n);
                i = j;
            } else if (s.charAt(i) == '*' || s.charAt(i) == '/') {
                int j = i + 1;
                while (j < s.length() && s.charAt(j) == ' ') j++;
                int k = j;
                while (j < s.length() && Character.isDigit(s.charAt(j))) {
                    j++;
                }

                int n = Integer.valueOf(s.substring(k, j));
                nums.addLast(cal(nums.removeLast(), n, s.charAt(i)));
                
                i = j;
            } else {
                i++;
            }
        }

        while (!ops.isEmpty()) {
            int n1 = nums.removeFirst();
            int n2 = nums.removeFirst();
            nums.addFirst(cal(n1, n2, ops.removeFirst()));
        }

        return nums.getFirst();
    }

    private int cal(int n1, int n2, char op) {
        if (op == '+') return n1 + n2;
        if (op == '-') return n1 - n2;
        if (op == '*') return n1 * n2;
        if (op == '/') return n1 / n2;
        
        return 0;
    }
}