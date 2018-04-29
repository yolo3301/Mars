class Solution {
    public String toGoatLatin(String S) {
        String[] words = S.split(" ");
        StringBuilder sb = new StringBuilder();
        String v = "aeiouAEIOU";
        String tail = "a";
        for (String s : words) {
            String cur = null;
            if (v.indexOf(s.charAt(0)) >= 0) {
                cur = s + "ma" + tail;
            } else {
                cur = s.substring(1) + s.substring(0, 1) + "ma" + tail;
            }

            tail += "a";
            sb.append(cur).append(" ");
        }

        return sb.toString().trim();
    }
}