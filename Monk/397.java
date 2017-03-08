public class Solution {
    public int integerReplacement(int n) {
        int cnt = 0;
        // Use unsigned shift >>> to prevent int overflow
        while (n != 1) {
            if ((n & 1) == 0) {
                n >>>= 1;
            } else if (n == 3 || ((n >>> 1) & 1) == 0) {
                n--;
            } else {
                n++;
            }
            cnt++;
        }

        return cnt;
    }
}