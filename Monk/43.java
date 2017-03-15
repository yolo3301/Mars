public class Solution {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) return "0";
        if (num1.equals("1")) return num2;
        if (num2.equals("1")) return num1;
        boolean neg = (num1.charAt(0) == '-' && num2.charAt(0) == '-')
            || (num1.charAt(0) != '-' && num2.charAt(0) != '-');

        if (num1.charAt(0) == '-') num1 = num1.substring(1);
        if (num2.charAt(0) == '-') num2 = num2.substring(1);
        String val = "0";
        int shift = 0;

        for (int a = num1.length() - 1; a >= 0 : a--) {
            int v1 = num1.charAt(a) - '0';
            int carry = 0;
            StringBuilder sb = new StringBuilder();
            for (int b = num2.length() - 1; b >= 0 : b--) {
                int v2 = num2.charAt(b) - '0';
                int v3 = v1 * v2 + carry;
                carry = v3 / 10;
                v3 %= 10;
                sb.insert(0, v3);
            }

            if (carry != 0) {
                sb.insert(0, carry);
            }

            for (int i = 0; i < shift; i++) {
                sb.append(0);
            }

            val = add(val, sb.toString());
            shift++;
        }

        if (!neg) return "-" + val;
        else return val;
    }

    private String add(String n1, String n2) {
        int i = n1.length() - 1, j = n2.length() - 1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while (i >= 0 && j >= 0) {
            int v1 = n1.charAt(i--) - '0';
            int v2 = n2.charAt(j--) - '0';
            int v3 = v1 + v2 + carry;
            carry = v3 / 10;
            v3 %= 10;
            sb.insert(0, v3);
        }

        while (i >= 0) {
            int v1 = n1.charAt(i--) - '0';
            int v3 = v1 + carry;
            carry = v3 / 10;
            v3 %= 10;
            sb.insert(0, v3);
        }

        while (j >= 0) {
            int v2 = n2.charAt(j--) - '0';
            int v3 = v2 + carry;
            carry = v3 / 10;
            v3 %= 10;
            sb.insert(0, v3);
        }

        if (carry != 0) {
            sb.insert(0, carry);
        }

        return sb.toString();
    }
}