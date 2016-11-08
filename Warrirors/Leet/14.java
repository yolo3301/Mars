public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        StringBuilder sb = new StringBuilder();
        int j = 0;
        while (true) {
            char curr = '`';
            boolean same = true, stop = false;
            for (int i = 0; i < strs.length; i++) {
                if (j >= strs[i].length()) {
                    stop = true;
                    break;
                }
                if (i == 0) {
                    curr = strs[i].charAt(j);
                } else {
                    if (curr != strs[i].charAt(j)) {
                        same = false;
                        break;
                    }
                }
            }

            if (same && !stop) {
                sb.append(curr);
            } else {
                break;
            }

            j++;
        }

        return sb.toString();
    }
}
