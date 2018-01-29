class Solution {
    public boolean isIdealPermutation(int[] A) {
        int max = A[0];
        for (int i = 2; i < A.length; i++) {
            if (A[i] < max)
                return false;
            max = Math.max(max, A[i-1]);
        }
        return true;
    }
}