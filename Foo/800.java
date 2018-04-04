class Solution {
    public String similarRGB(String color) {
        StringBuilder sb = new StringBuilder("#");
        for (int i = 1; i < 7; i += 2) {
            char c = color.charAt(i);
            String o = color.substring(i, i+2);
            String cand1 = new String(new char[]{c, c});
            String ret = cand1;
            int d = diff(cand1, o);

            if (c != '0' && c != 'a') {
                String cand2 = new String(new char[]{(char)(c-1), (char)(c-1)});
                int t = diff(o, cand2);
                if (t < d) {
                    d = t;
                    ret = cand2;
                }
            }
            
            if (c == 'a') {
                int t = diff(o, "99");
                if (t < d) {
                    d = t;
                    ret = "99";
                }
            }

            if (c != 'f' && c != '9') {
                String cand3 = new String(new char[]{(char)(c+1), (char)(c+1)});
                int t = diff(cand3, o);
                if (t < d) {
                    d = t;
                    ret = cand3;
                }
            }
            
            if (c == '9') {
                int t = diff(o, "aa");
                if (t < d) {
                    d = t;
                    ret = "aa";
                }
            }

            sb.append(ret);
        }

        return sb.toString();
    }

    private int diff(String v1, String v2) {
        int ret = 0;

        if (v1.charAt(0) < v2.charAt(0)
            || (v1.charAt(0) == v2.charAt(0) && v1.charAt(1) < v2.charAt(1))) {
            String tmp = v1;
            v1 = v2;
            v2 = tmp;
        }

        int x1 = v1.charAt(1) >= 'a' ? v1.charAt(1) - 'a' + 10 : v1.charAt(1) - '0';
        int x2 = v2.charAt(1) >= 'a' ? v2.charAt(1) - 'a' + 10 : v2.charAt(1) - '0';

        int carry = 0;
        if (x1 < x2) {
            carry = 1;
            x1 += 16;
        }

        ret += x1 - x2;

        x1 = v1.charAt(0) >= 'a' ? v1.charAt(0) - 'a' + 10 : v1.charAt(0) - '0';
        x2 = v2.charAt(0) >= 'a' ? v2.charAt(0) - 'a' + 10 : v2.charAt(0) - '0';

        x1 -= carry;

        ret += (x1 - x2) * 16;

        return ret;
    }
}