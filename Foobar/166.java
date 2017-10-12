class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) return "0";
        String sign = ((long)numerator * (long)denominator) < 0 ? "-" : "";

        long v1 = Math.abs((long)numerator);
        long v2 = Math.abs((long)denominator);

        String p1 = sign + (v1 / v2);
        if (v1 % v2 == 0) return p1;

        p1 = p1 + ".";

        Map<Long, Integer> index = new HashMap<>(); // remaining => index
        String p2 = "";
        long remaining = (v1 % v2) * 10;
        while (remaining != 0) {
            index.put(remaining, p2.length());
            p2 += (remaining / v2);
            remaining = (remaining % v2) * 10;
            if (index.containsKey(remaining)) {
                p2 = p2.substring(0, index.get(remaining)) + "(" + p2.substring(index.get(remaining), p2.length()) + ")";
                break;
            }
        }

        return p1+p2;
    }
}

