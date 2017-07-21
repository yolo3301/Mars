public class Solution {
    public String solveEquation(String equation) {
        String[] eq = equation.split("=");
        String left = eq[0];
        if (left.charAt(0) != '+' && left.charAt(0) != '-')
            left = "+" + left;
        String right = eq[1];
        if (right.charAt(0) != '+' && right.charAt(0) != '-')
            right = "+" + right;

        int xs = 0;
        int ns = 0;

        for (int i = 0; i < left.length(); ) {
            int j = i+1;
            while (j < left.length() && left.charAt(j) != '+' && left.charAt(j) != '-' && left.charAt(j) != 'x')
                j++;

            int num = j>i+1 ? Integer.valueOf(left.substring(i+1, j)) : 1;
            if (left.charAt(i) == '-') num = -num;

            if (j < left.length() && left.charAt(j) == 'x') {
                xs += num;
                i = j+1;
            } else {
                ns -= num;
                i = j;
            }
        }

        for (int i = 0; i < right.length(); ) {
            int j = i+1;
            while (j < right.length() && right.charAt(j) != '+' && right.charAt(j) != '-' && right.charAt(j) != 'x')
                j++;

            int num = j>i+1 ? Integer.valueOf(right.substring(i+1, j)) : 1;
            if (right.charAt(i) == '-') num = -num;

            if (j < right.length() && right.charAt(j) == 'x') {
                xs -= num;
                i = j+1;
            } else {
                ns += num;
                i = j;
            }
        }

        if (xs == 0 && ns == 0) return "Infinite solutions";
        if (xs == 0) return "No solution";

        int v = ns / xs;

        return "x=" + v;
    }
}