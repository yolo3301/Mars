public class Solution {
    public String addStrings(String num1, String num2) {
        if (num1.equals("0")) return num2;
        if (num2.equals("0")) return num1;

        StringBuilder sb = new StringBuilder();
        int c = 0;

        int i = num1.length() - 1, j = num2.length() - 1;
        while (i >= 0 && j >= 0) {
            int n1 = num1.charAt(i--) - '0';
            int n2 = num2.charAt(j--) - '0';
            int s = n1 + n2 + c;
            c = s / 10;
            sb.append(s % 10);
        }

        while (i >= 0) {
            int n1 = num1.charAt(i--) - '0';
            int s = n1 + c;
            c = s / 10;
            sb.append(s % 10);
        }

        while (j >= 0) {
            int n2 = num2.charAt(j--) - '0';
            int s = n2 + c;
            c = s / 10;
            sb.append(s % 10);
        }

        if (c != 0) sb.append(c);

        return sb.reverse().toString();
    }
}
