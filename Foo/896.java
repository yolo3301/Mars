class Solution {
    public boolean isMonotonic(int[] A) {
        if (A.length == 1) return true;
        boolean inc = false, set = false;
        for (int i = 1; i < A.length; i++) {
            if (A[i] > A[i-1]) {
                if (set && !inc) return false;
                inc = true;
                set = true;
            } else if (A[i] < A[i-1]) {
                if (set && inc) return false;
                inc = false;
                set = true;
            }
        }
        return true;
    }
}