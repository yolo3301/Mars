public class Solution {
    public int maxRotateFunction(int[] A) {
         if (A.length == 0) return 0;
         int len = A.length;

         int sum = 0;
         int[] f = new int[len];
         for (int i = 0; i < len; i++) {
             sum += A[i];
             f[0] += i * A[i];
         }

         int res = f[0];

         for (int i = 1; i < len; i++) {
            int last = A[len - i];
            f[i] = f[i-1] + sum - (len * last);
            res = Math.max(res, f[i]);
         }

         return res;
    }
}