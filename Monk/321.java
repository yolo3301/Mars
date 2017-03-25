public class Solution {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int[] res = new int[k];
        for (int i = Math.max(0, k - len2); i <= len1 && i <= k; i++) {
            int[] cand = merge(singleMax(nums1, i), singleMax(nums2, k - i), k);
            if (greater(cand, 0, res, 0)) res = cand;
        }

        return res;
    }

    private int[] merge(int[] nums1, int[] nums2, int k) {
        int[] res = new int[k];
        int i = 0, j = 0, p = 0;
        while (i < nums1.length && j < nums2.length) {
            res[p++] = greater(nums1, i, nums2, j) ? nums1[i++] : nums2[j++];
        }

        while (i < nums1.length) res[p++] = nums1[i++];
        while (j < nums2.length) res[p++] = nums2[j++];
        return res;
    }

    private boolean greater(int[] nums1, int i, int[] nums2, int j) {
        while (i < nums1.length && j < nums2.length && nums1[i] == nums2[j]) {
            i++;
            j++;
        }

        return j == nums2.length || (i < nums1.length && nums1[i] > nums2[j]);
    }

    private int[] singleMax(int[] nums, int k) {
        int[] res = new int[k];
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            while (i + nums.length - j > k && i > 0 && nums[j] > res[i-1]) {
                i--;
            }
            if (i < k) res[i++] = nums[j];
        }

        return res;
    }
}