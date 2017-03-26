public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len = nums1.length + nums2.length;

        if (len % 2 != 0) {
            return search(nums1, 0, nums2, 0, len/2+1);
        } else {
            return (search(nums1, 0, nums2, 0, len/2) + search(nums1, 0, nums2, 0, len/2+1)) / 2.0;
        }
    }

    private int search(int[] A, int m, int[] B, int n, int k) {
        int alen = A.length - m;
        int blen = B.length - n;

        if (alen > blen)
            return search(B, n, A, m, k);

        if (alen == 0) return B[n+k-1];

        if (k == 1) return Math.min(A[m], B[n]);

        int pa = Math.min(k/2, alen);
        int pb = k - pa;

        if (A[m+pa-1] == B[n+pb-1])
            return A[m+pa-1];
        else if (A[m+pa-1] < B[n+pb-1]) {
            return search(A, m + pa, B, n, k - pa);
        } else {
            return search(A, m, B, n + pb, k - pb);
        }
    }
}