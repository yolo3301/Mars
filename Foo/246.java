public class Solution {
    public boolean isStrobogrammatic(String num) {
        if (num.length() == 0) return true;
        for (int i = 0; i <= num.length() / 2; i++) {
            if (num.charAt(i) - '0' != getReplace(num.charAt(num.length() - 1 - i) - '0'))
                return false;
        }

        return true;
    }

    private int getReplace(int x) {
        if (x == 3 || x == 4 || x == 7 || x == 2 || x == 5) return -1;
        if (x == 1 || x == 8 || x == 0) return x;
        if (x == 6) return 9;
        if (x == 9) return 6;
        
        return -1;
    }
}