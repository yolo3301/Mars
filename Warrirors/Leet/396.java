// idea from: https://discuss.leetcode.com/topic/58616/java-solution-o-n-with-non-mathametical-explaination
public class Solution {
    public int maxRotateFunction(int[] A) {
        if (A.length == 0) return 0;
        int sum = 0, last = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
            last += i * A[i];
        }

        int max = last;
        for (int i = 0; i < A.length - 1; i++) {
            int curr = last + sum - (A.length * A[A.length - 1 - i]);
            max = Math.max(max, curr);
            last = curr;
        }

        return max;
    }
}
