// my original solution
public class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        if (A.length <= 2) return 0;
        int[] diffs = new int[A.length - 1];
        for (int i = 1; i < A.length; i++) {
            diffs[i-1] = A[i] - A[i-1];
        }

        int res = 0;
        int count = 1;
        int curr = diffs[0];
        for (int i = 1; i < diffs.length; i++) {
            if (diffs[i] == curr) {
                count++;
            } else {
                res += count * (count - 1) / 2;
                curr = diffs[i];
                count = 1;
            }
        }

        res += count * (count - 1) / 2;

        return res;
    }
}

// a simpler but subtle version
public class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        int res = 0;
        int curr = 0;
        for (int i = 2; i < A.length; i++) {
            if (A[i] - A[i-1] == A[i-1] - A[i-2]) {
                curr++;
                res += curr;
            } else {
                curr = 0;
            }
        }
        return res;
    }
}
