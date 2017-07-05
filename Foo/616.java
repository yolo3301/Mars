public class Solution {
    public String addBoldTag(String s, String[] dict) {
        Set<String> set = new HashSet<>();
        for (String w : dict) {
            set.add(w);
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); ) {
            int b = i;
            for (int j = i; j <= b; j++) {
                for (String w : dict) {
                    if (s.substring(j).startsWith(w)) {
                        b = Math.max(b, j + w.length()-1);
                    }
                }
            }
            if (b == i && !set.contains(s.substring(i, i+1))) {
                sb.append(s.charAt(i));
                i++;
            } else {
                if (sb.length() > 4 && sb.substring(sb.length()-4).equals("</b>")) {
                    sb.replace(sb.length()-4, sb.length(), "").append(s.substring(i, b+1)).append("</b>");
                } else {
                    sb.append("<b>").append(s.substring(i, b+1)).append("</b>");
                }
                i = b+1;
            }
        }

        return sb.toString();
    }
}