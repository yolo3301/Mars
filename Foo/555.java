public class Solution {
    public String splitLoopedString(String[] strs) {
        String full = "", res = "a";
        for (String s : strs) {
            String r = reverse(s);
            if (s.compareTo(r) >= 0) full += s;
            else full += r;
        }

        for (int i = 0, slen = 0; i < strs.length; slen += strs[i++].length()) {
            String p1 = strs[i], p2 = reverse(strs[i]);
            String body = full.substring(slen+p1.length()) + full.substring(0, slen);
            for (int j = 0; j < p1.length(); j++) {
                String cand1 = p1.substring(j) + body + p1.substring(0, j);
                String cand2 = p2.substring(j) + body + p2.substring(0, j);
                if (cand1.compareTo(res) > 0) res = cand1;
                if (cand2.compareTo(res) > 0) res = cand2;
            }
        }

        return res;
    }

    private String reverse(String s) {
        return new StringBuilder(s).reverse().toString();
    }
}