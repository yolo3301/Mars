/*
Median of Two Sorted Arrays

There are two sorted arrays nums1 and nums2 of size m and n respectively.

Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

Example 1:
nums1 = [1, 3]
nums2 = [2]

The median is 2.0
Example 2:
nums1 = [1, 2]
nums2 = [3, 4]

The median is (2 + 3)/2 = 2.5
*/

public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len = nums1.length + nums2.length;
        if (len % 2 == 1)
            return findKth(nums1, 0, nums2, 0, len / 2 + 1);
        return ( findKth(nums1, 0, nums2, 0, len / 2) + findKth(nums1, 0, nums2, 0, len / 2 + 1)) / 2.0;
    }
    
    private int findKth(int[] nums1, int i1, int[] nums2, int i2, int k) {
        if (i1 >= nums1.length)
            return nums2[i2+k-1];
        if (i2 >= nums2.length)
            return nums1[i1+k-1];
        
        if (k == 1)
            return Math.min(nums1[i1], nums2[i2]);
        
        int v1 = i1 + k / 2 - 1 < nums1.length ? nums1[i1+k/2-1] : Integer.MAX_VALUE;
        int v2 = i2 + k / 2 - 1 < nums2.length ? nums2[i2+k/2-1] : Integer.MAX_VALUE;
        
        if (v1 < v2)
            return findKth(nums1, i1 + k / 2, nums2, i2, k - k / 2);
        else
            return findKth(nums1, i1, nums2, i2 + k / 2, k - k / 2);
    }
}