public class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        int res = 0, prevCnt = 0, prevDiff = 0;
        for (int i = 1; i < A.length; i++) {
            int diff = A[i] - A[i-1];
            if (prevDiff == diff) {
                res += prevCnt;
                prevCnt++;
            } else {
                prevDiff = diff;
                prevCnt = 1;
            }
        }

        return res;
    }
}