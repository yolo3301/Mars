public class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int s = -1, e = -1;
        int prevMax = A[0], lastMin = A[nums.length-1];
        for (int i = 1; i < nums.length; i++) {
            prevMax = Math.max(prevMax, A[i]); // left o right to find end point
            lastMin = Math.min(lastMin, A[nums.length-1-i]); // right to left to find start point
            if (prevMax > A[i]) e = i;
            if (lastMin < A[nums.length-1-i]) s = nums.length-1-i;
        }

        if (s < 0 && e < 0) return 0;
        return e - s + 1;
    }
}