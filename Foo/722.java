class Solution {
    public List<String> removeComments(String[] source) {
        List<String> ret = new ArrayList<>();

        boolean inComment = false;

        for (int i = 0; i < source.length; i++) {
            boolean prevComment = inComment;
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < source[i].length(); j++) {
                if (!inComment && source[i].charAt(j) == '/'
                    && j+1 < source[i].length()
                    && (source[i].charAt(j+1) == '/' || source[i].charAt(j+1) == '*')) {

                    if (source[i].charAt(j+1) == '/') {
                        // the rest of line is comment
                        break;
                    } else if (source[i].charAt(j+1) == '*') {
                        inComment = true;
                    }

                    j++;

                } else if (source[i].charAt(j) == '*'
                    && j+1 < source[i].length()
                    && source[i].charAt(j+1) == '/') {
                    if (inComment) {
                        inComment = false;
                        j++;
                    } else {
                        sb.append('*');
                    }
                } else if (!inComment) {
                    sb.append(source[i].charAt(j));
                }
            }

            if (sb.length() > 0) {
                if (prevComment && !inComment) {
                    String last = ret.get(ret.size()-1);
                    ret.set(ret.size()-1, last+sb.toString());
                } else {
                    ret.add(sb.toString());
                }
            }
        }

        return ret;
    }
}

