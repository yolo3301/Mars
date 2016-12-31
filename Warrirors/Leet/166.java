public class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) return "0";
        boolean neg = (numerator > 0 && denominator < 0) || (numerator < 0 && denominator > 0);

        long n = Math.abs((long) numerator);
        long d = Math.abs((long) denominator);

        StringBuilder sb = new StringBuilder();
        sb.append(n/d);

        long left = (n % d) * 10;
        if (left == 0) {
            if (neg) return "-" + sb.toString();
            else return sb.toString();
        }

        sb.append('.');

        Map<Long, Integer> index = new HashMap<>();
        String dec = "";
        int k = 0;
        while (left != 0) {
            if (!index.containsKey(left)) {
                index.put(left, k++);
                long curr = left / d;
                dec += Long.toString(curr);
                left = (left % d) * 10;
            } else {
                int prev = index.get(left);
                for (int i = 0; i < dec.length(); i++) {
                    if (i == prev) {
                        sb.append('(');
                    }
                    sb.append(dec.charAt(i));
                }
                sb.append(')');
                break;
            }
        }

        if (left == 0) {
            sb.append(dec);
        }

        if (neg) return "-" + sb.toString();
        else return sb.toString();
    }
}
