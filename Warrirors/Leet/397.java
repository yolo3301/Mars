// reference: https://discuss.leetcode.com/topic/58334/a-couple-of-java-solutions-with-explanations/2
public class Solution {
    public int integerReplacement(int n) {
        int c = 0;
        while (n != 1) {
            if ((n & 1) == 0) {
                n >>>= 1;
            } else if (n == 3 || ((n >>> 1) & 1) == 0) {
                n--;
            } else {
                n++;
            }
            c++;
        }

        return c;
    }
}
