class Solution {
    public int lengthLongestPath(String input) {
        if (input.length() == 0) return 0;
        Stack<String> stack = new Stack<>();
        int level = 0;
        int ret = 0, len = 0;
        
        for (int i = 0; i < input.length(); ) {
            int j = i;
            
            while (j < input.length() && input.charAt(j) == '\t') j++;
            int tabs = j - i;
            i = j;
            
            while (j < input.length() && input.charAt(j) != '\n') j++;
            String cur = input.substring(i, j);
            
            while (!stack.empty() && tabs <= level) {
                String prev = stack.pop();
                len -= prev.length()+1;
                level--;
            }
            stack.push(cur);
            len += cur.length()+1;
            level = tabs;
            
            if (cur.contains(".")) {
                ret = Math.max(ret, len - 1);
            }
            
            i = j+1;
        }

        return ret;
    }
}

