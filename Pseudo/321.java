public class Solution {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int[] res = new int[k];
        for (int i = Math.max(0, k-nums2.length); i <= Math.min(nums1.length, k); i++) {
            int k1 = i;
            int k2 = k - i;
            int[] cand = merge(getMax(nums1, k1), 0, getMax(nums2, k2), 0, k);
            if (greater(cand, 0, res, 0)) res = cand;
        }

        return res;
    }

    private int[] merge(int[] nums1, int i1, int[] nums2, int i2, int k) {
        int[] res = new int[k];
        int j = 0;
        while (i1 < nums1.length || i2 < nums2.length) {
            if (i1 == nums1.length) res[j++] = nums2[i2++];
            else if (i2 == nums2.length) res[j++] = nums1[i1++];
            else if (greater(nums1, i1, nums2, i2)) res[j++] = nums1[i1++];
            else res[j++] = nums2[i2++];
        }

        return res;
    }

    private boolean greater(int[] nums1, int i1, int[] nums2, int i2) {
        while (i1 < nums1.length && i2 < nums2.length && nums1[i1] == nums2[i2]) {
            i1++;
            i2++;
        }

        return i2 == nums2.length || (i1 < nums1.length && nums1[i1] > nums2[i2]);
    }

    private int[] getMax(int[] nums, int k) {
        int[] res = new int[k];
        int len = 0;
        for (int i = 0; i < nums.length; i++) {
            while (len > 0 && nums[i] > res[len-1] && len + nums.length - i > k) {
                len--;
            }

            if (len < res.length) {
                res[len++] = nums[i];
            }
        }

        return res;
    }
}