// https://discuss.leetcode.com/topic/12133/bit-operation-solution-java

public class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        if (m == 0) return 0;
        int move = 1;
        while (m != n) {
            m >>= 1;
            n >>= 1;
            move <<= 1;
        }

        return m * move;
    }
}
