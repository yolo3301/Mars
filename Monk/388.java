public class Solution {
    public int lengthLongestPath(String input) {
        if (input.length() == 0) return 0;
        String[] path = input.split("\\\\n");
        int len = 0, res = 0;
        Stack<String> dir = new Stack<>();
        Stack<Integer> lvl = new Stack<>();

        for (String p : path) {
            int tabs = 0;
            for ( ; tabs < p.length(); tabs++) {
                if (p.charAt(tabs) != '\t') break;
            }
            p = p.substring(tabs);

            while (!lvl.empty() && lvl.peek() >= tabs) {
                lvl.pop();
                String tmp = dir.pop();
                len -= tmp.length();
            }

            dir.push(p);
            lvl.push(tabs);
            len += p.length();

            System.out.println(dir);
            System.out.println(lvl);

            if (p.contains(".")) {
                res = Math.max(res, len + dir.size() - 1);
            }
        }

        return res;
    }
}