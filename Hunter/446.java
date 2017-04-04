public class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        if (A.length < 3) return 0;
        int res = 0;
        Map<Integer, Integer>[] prev = new HashMap[A.length];
        for (int i = 0; i < A.length; i++) {
            prev[i] = new HashMap<>();
            for (int j = 0; j < i; j++) {
                if ((long)A[i]-A[j] > Integer.MAX_VALUE || (long)A[i]-A[j] < Integer.MIN_VALUE) continue;
                int diff = A[i] - A[j];
                int prevCnt = prev[j].getOrDefault(diff, 0);
                int currCnt = prev[i].getOrDefault(diff, 0);

                prev[i].put(diff, prevCnt + currCnt + 1);
                res += prevCnt;
            }
        }

        return res;
    }
}