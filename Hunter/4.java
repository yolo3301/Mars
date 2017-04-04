public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len = nums1.length + nums2.length;
        if (len%2 == 0) {
            return (findKth(nums1, 0, nums2, 0, len/2+1)+findKth(nums1, 0, nums2, 0, len/2)) / 2.0;
        } else {
            return findKth(nums1, 0, nums2, 0, len/2+1);
        }
    }

    private int findKth(int[] nums1, int m, int[] nums2, int n, int k) {
        int len1 = nums1.length - m;
        int len2 = nums2.length - n;

        if (len1 > len2)
            return findKth(nums2, n, nums1, m, k);

        if (len1 == 0) return nums2[n+k-1];

        if (k == 1) return Math.min(nums1[m], nums2[n]);

        int p = Math.min(k/2, len1);
        int q = k - p;

        if (nums1[m+p-1] == nums2[n+q-1]) return nums1[m+p-1];
        else if (nums1[m+p-1] > nums2[n+q-1])
            return findKth(nums1, m, nums2, n+q, k-q);
        else return findKth(nums1, m+p, nums2, n, k-p);
    }
}