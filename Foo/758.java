class Solution {
    public String boldWords(String[] words, String S) {
        if (words.length == 0 || S.length() == 0) return S;
        int boarder = -1;
        StringBuilder ret = new StringBuilder();
        StringBuilder boldBuf = new StringBuilder();
        for (int i = 0; i < S.length(); i++) {
            for (String str : words) {
                int len = str.length();
                if (str.equals(S.substring(i, Math.min(i+len, S.length())))) {
                    boarder = Math.max(boarder, i+len);
                }
            }

            if (i < boarder) {
                boldBuf.append(S.charAt(i));
            } else {
                if (i == boarder) {
                    ret.append("<b>").append(boldBuf.toString()).append("</b>");
                    boldBuf = new StringBuilder();
                }
                ret.append(S.charAt(i));
            }
        }

        if (boarder == S.length())
            ret.append("<b>").append(boldBuf.toString()).append("</b>");

        return ret.toString();
    }
}