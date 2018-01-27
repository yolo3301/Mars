class Solution {
    public int calculate(String s) {
        long l1 = 0, o1 = 1;
        long l2 = 1, o2 = 1;

        /*
        l1 is the level 1 value
        l2 is the level 2 value which is the eval from the current expression
        o2 is for l2, for only represents * and /
        o1 is for l1, for only represents + and -

        when see + and - or the end of string, then we can update l1 based the current l2
        for all other, just update l2
         */

        Stack<Long> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                int j = i;
                while (j < s.length() && Character.isDigit(s.charAt(j)))
                    j++;
                
                long cur = Long.valueOf(s.substring(i, j));
                l2 = (o2 == 1 ? l2 * cur : l2 / cur);
                i = j-1;
            } else if (s.charAt(i) == '(') {
                stack.push(l1); stack.push(o1);
                stack.push(l2); stack.push(o2);

                l1 = 0; o1 = 1;
                l2 = 1; o2 = 1;
            } else if (s.charAt(i) == ')') {
                long cur = l1 + o1 * l2;

                o2 = stack.pop(); l2 = stack.pop();
                o1 = stack.pop(); l1 = stack.pop();

                l2 = (o2 == 1 ? l2 * cur : l2 / cur);
            } else if (s.charAt(i) == '*' || s.charAt(i) == '/') {
                o2 = (s.charAt(i) == '*' ? 1 : -1);
            } else if (s.charAt(i) == '+' || s.charAt(i) == '-') {
                l1 = l1 + o1 * l2;
                o1 = (s.charAt(i) == '+' ? 1 : -1);
                l2 = 1; o2 = 1;
            }
        }

        return (int)(l1 + o1 * l2);
    }
}