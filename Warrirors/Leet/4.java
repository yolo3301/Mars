// See note in evernote O(logK) = O(log(m+n))
public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        if ((m + n) % 2 == 1)
            return search(nums1, 0, nums2, 0, (m+n) / 2 + 1);
        else
            return (search(nums1, 0, nums2, 0, (m+n) / 2) + search(nums1, 0, nums2, 0, (m+n) / 2 + 1)) / 2.0;
    }

    private int search(int[] A, int m, int[] B, int n, int k) {
        int alen = A.length - m;
        int blen = B.length - n;

        if (alen > blen)
            return search(B, n, A, m, k);

        if (alen == 0)
            return B[n+k-1];

        if (k == 1)
            return Math.min(A[m], B[n]);

        int pa = Math.min(alen, k / 2);
        int pb = k - pa;

        if (A[m + pa - 1] == B[n + pb - 1])
            return A[m + pa - 1];
        else if (A[m + pa - 1] < B[n + pb - 1]) {
            return search(A, m + pa, B, n, k - pa);
        } else {
            return search(A, m, B, n + pb, k - pb);
        }
    }
}
