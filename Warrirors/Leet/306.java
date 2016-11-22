import java.math.BigInteger;

public class Solution {
    public boolean isAdditiveNumber(String num) {
        int len = num.length();
        for (int i = 1; i <= len / 2; i++) {
            for (int j = 1; Math.max(i, j) <= len - i - j; j++) {
                if (isValid(i, j, num)) return true;
            }
        }
        return false;
    }

    private boolean isValid(int i, int j, String num) {
        if (num.charAt(0) == '0' && i > 1 || num.charAt(i) == '0' && j > 1) return false;
        int len = num.length();
        BigInteger x1 = new BigInteger(num.substring(0, i));
        BigInteger x2 = new BigInteger(num.substring(i, i + j));
        int k = i + j;
        while (k < num.length()) {
            String sum = x1.add(x2).toString();
            if (k + sum.length() > num.length()) return false;
            String tmp = num.substring(k, k + sum.length());
            if (!sum.equals(tmp)) return false;
            x1 = x2;
            x2 = new BigInteger(sum);
            k = k + sum.length();
        }

        return true;
    }
}
