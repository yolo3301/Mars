public class Solution {
    public String decodeString(String s) {
        if (s.length() == 0) return "";
        Stack<String> q = new Stack<>();
        int i = 0;

        while (i < s.length()) {
            if (s.charAt(i) == '[') {
                q.push("[");
                i++;
            } else if (s.charAt(i) == ']') {
                StringBuilder sb = new StringBuilder();
                while (!q.empty() && q.peek() != "[") {
                    sb.insert(0, q.pop());
                }
                q.pop();
                int rep = Integer.parseInt(q.pop());
                String tmp = sb.toString();
                for (int k = 0; k < rep - 1; k++) sb.append(tmp);
                q.push(sb.toString());
                i++;
            } else {
                int j = i;
                while (j < s.length() && Character.isDigit(s.charAt(j))) {
                    j++;
                }
                if (j > i) {
                    q.push(s.substring(i, j));
                    i = j;
                }
                while (j < s.length() && Character.isLetter(s.charAt(j))) {
                    j++;
                }
                if (j > i)
                    q.push(s.substring(i, j));
                i = j;
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!q.empty()) {
            sb.insert(0, q.pop());
        }

        return sb.toString();
    }
}