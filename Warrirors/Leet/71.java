public class Solution {
    public String simplifyPath(String path) {
        String[] parts = path.split("/");
        Deque<String> s = new LinkedList<>();
        for (int i = 0; i < parts.length; i++) {
            String curr = parts[i];
            if (curr != null && !curr.isEmpty()) {
                if (curr.equals("..")) {
                    if (!s.isEmpty()) s.removeLast();
                } else if (curr.equals(".")) {
                    continue;
                } else {
                    s.addLast(curr);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!s.isEmpty()) {
            sb.append('/');
            sb.append(s.removeFirst());
        }

        return sb.length() == 0 ? "/" : sb.toString();
    }
}
