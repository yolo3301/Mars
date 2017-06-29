public class Solution {
    public String fractionAddition(String expression) {
        if (expression.charAt(0) != '-') {
            expression = "+" + expression;
        }

        int a = 0, b = 0;
        char pop = '+';
        int i = 0;
        while (i < expression.length()) {
            char op = expression.charAt(i);
            int j = i+1;
            while (j < expression.length() && expression.charAt(j) != '+' && expression.charAt(j) != '-')
                j++;
            
            String curr = expression.substring(i+1, j);
            String[] parts = curr.split("/");
            int v1 = Integer.valueOf(parts[0]);
            int v2 = Integer.valueOf(parts[1]);

            if (b == 0) {
                pop = op;
                a = v1;
                b = v2;
            } else {
                int l = lcm(b, v2);
                int t1 = a * (l / b);
                int t2 = v1 * (l / v2);
                if (pop == '-') t1 = -t1;
                if (op == '-') t2 = -t2;
                int t = t1+t2;
                int abst = Math.abs(t);
                int g = gcd(abst, l);
                a = abst / g;
                b = l / g;
                pop = t >= 0 ? '+' : '-';
            }

            i = j;
        }
        
        if (pop == '+') return a + "/" + b;
        return "-" + a + "/" + b;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int tmp = a % b;
            a = b;
            b = tmp;
        }

        return a;
    }

    private int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }
}