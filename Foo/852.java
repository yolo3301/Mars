class Solution {
    public int peakIndexInMountainArray(int[] A) {
        int max = -1;
        int ret = -1;
        for (int i = 0; i < A.length; i++) {
            if (A[i] > max) {
                max = A[i];
                ret = i;
            }
        }
        return ret;
    }
}