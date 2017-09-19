class Solution {
    public boolean validPalindrome(String s) {
        if (s.length() <= 1) return true;

        int i = 0, j = s.length() - 1;
        boolean isPan = true, mismatch = false;

        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                if (mismatch) isPan = false;
                mismatch = true;
                i++;
            } else {
                i++;
                j--;
            }
        }

        if (isPan) return true;

        i = 0;
        j = s.length() - 1;
        mismatch = false;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                if (mismatch) return false;
                mismatch = true;
                j--;
            } else {
                i++;
                j--;
            }
        }

        return true;
    }
}