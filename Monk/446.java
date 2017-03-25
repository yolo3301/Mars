public class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        if (A.length < 3) return 0;
        Map<Integer, Integer>[] map = new HashMap[A.length];
        int res = 0;
        for (int i = 0; i < A.length; i++) {
            map[i] = new HashMap<>();
            for (int j = 0; j < i; j++) {
                if ((long)A[i]-A[j] > Integer.MAX_VALUE 
                    || (long)A[i]-A[j] < Integer.MIN_VALUE)
                    continue;
                int prev = map[j].getOrDefault(A[i]-A[j], 0);
                int cnt = map[i].getOrDefault(A[i]-A[j], 0);
                map[i].put(A[i]-A[j], cnt + prev + 1);
                res += prev;
            }
        }

        return res;
    }
}