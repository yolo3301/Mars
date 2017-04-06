public class Solution {
    public String decodeString(String s) {
        if (s.length() == 0) return "";
        Stack<String> stack = new Stack<>();
        int i = 0;
        while (i < s.length()) {
            if (Character.isDigit(s.charAt(i))) {
                int j = i;
                while (j < s.length() && Character.isDigit(s.charAt(j))) {
                    j++;
                }

                stack.push(s.substring(i, j));
                i = j;
            } else if (Character.isLetter(s.charAt(i))
                || s.charAt(i) == '[') {
                stack.push(Character.toString(s.charAt(i)));
                i++;
            } else if (s.charAt(i) == ']') {
                StringBuilder sb = new StringBuilder();
                while (!stack.peek().equals("[")) {
                    sb.insert(0, stack.pop());
                }

                stack.pop();
                int cnt = Integer.parseInt(stack.pop());
                String rep = sb.toString();
                for (int k = 0; k < cnt - 1; k++)
                    sb.append(rep);
                
                stack.push(sb.toString());

                i++;
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.empty())
            sb.insert(0, stack.pop());
    }
}