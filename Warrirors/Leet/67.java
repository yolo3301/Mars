public class Solution {
    public String addBinary(String a, String b) {
        if (a.length() == 0) return b;
        if (b.length() == 0) return a;

        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1, j = b.length() - 1;
        boolean carry = false;

        while (i >= 0 && j >= 0) {
            char c1 = a.charAt(i--);
            char c2 = b.charAt(j--);
            if (c1 == '0' && c2 == '0') {
                if (carry) {
                    sb.append(1);
                } else {
                    sb.append(0);
                }
                carry = false;
            } else if (c1 == '1' && c2 == '1') {
                if (carry) {
                    sb.append(1);
                } else {
                    sb.append(0);
                }
                carry = true;
            } else {
                if (carry) {
                    sb.append(0);
                } else {
                    sb.append(1);
                }
            }
        }

        while (i >= 0) {
            char c = a.charAt(i--);
            if (c == '0') {
                if (carry) {
                    sb.append(1);
                    carry = false;
                } else {
                    sb.append(0);
                }
            } else {
                if (carry) {
                    sb.append(0);
                } else {
                    sb.append(1);
                }
            }
        }

        while (j >= 0) {
            char c = b.charAt(j--);
            if (c == '0') {
                if (carry) {
                    sb.append(1);
                    carry = false;
                } else {
                    sb.append(0);
                }
            } else {
                if (carry) {
                    sb.append(0);
                } else {
                    sb.append(1);
                }
            }
        }

        if (carry) sb.append(1);

        return sb.reverse().toString();
    }
}
