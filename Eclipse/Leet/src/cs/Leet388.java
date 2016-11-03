package cs;

import java.util.Stack;

public class Leet388 {
	public int lengthLongestPath(String input) {
        if (input.length() == 0) return 0;
        char[] chs = input.toCharArray();
        int res = 0, i = 0, level = 0;
        Stack<Integer> s = new Stack<>();
        s.push(0);

        while (i < chs.length) {
            if (chs[i] != '\n' && chs[i] != '\t') {
                boolean isFile = false;
                int nameLen = 0;
                while (i < chs.length && chs[i] != '\n') {
                    nameLen++;
                    if (chs[i] == '.') isFile = true;
                    i++;
                }
                
                System.out.println("len:" + nameLen + " file:" + isFile);

                if (!isFile) {
                    s.push(s.peek() + nameLen + 1);
                    level++;
                } else {
                    res = Math.max(res, s.peek() + 1 + nameLen);
                }
            } else {
                int nt = 0;
                i++;
                while (i < chs.length && chs[i] == '\t') {
                    i++;
                    nt++;
                }
                
                System.out.println("# of t:" + nt);

                while (level > nt) {
                    level--;
                    s.pop();
                }
            }
        }

        return res - 1;
    }
}
