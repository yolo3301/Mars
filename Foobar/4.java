class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len = nums1.length + nums2.length;
        if (len % 2 == 0) {
            return (findKth(nums1, 0, nums2, 0, len/2)+findKth(nums1, 0, nums2, 0, len/2+1)) / 2.0;
        } else {
            return (double)findKth(nums1, 0, nums2, 0, len/2+1);
        }
    }

    private int findKth(int[] nums1, int s1, int[] nums2, int s2, int k) {
        int len1 = nums1.length - s1;
        int len2 = nums2.length - s2;
        if (len1 > len2) {
            return findKth(nums2, s2, nums1, s1, k);
        }

        if (len1 == 0) {
            return nums2[s2+k-1];
        }
        
        if (k == 1) return Math.min(nums1[s1], nums2[s2]);

        int p1 = Math.min(len1, k/2);
        int p2 = k - p1;

        if (nums1[s1+p1-1] == nums2[s2+p2-1]) return nums1[s1+p1-1];
        else if (nums1[s1+p1-1] < nums2[s2+p2-1]) {
            return findKth(nums1, s1+p1, nums2, s2, k-p1);
        } else {
            return findKth(nums1, s1, nums2, s2+p2, k-p2);
        }
    }
}