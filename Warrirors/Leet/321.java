// reference: https://discuss.leetcode.com/topic/32272/share-my-greedy-solution
public class Solution {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int len1 = nums1.length;
        int len2 = nums2.length;

        int[] res = new int[k];
        for (int i = Math.max(0, k - len2); i <= k && i <= len1; i++) {
            int[] cand = merge(singleMax(nums1, i), singleMax(nums2, k - i), k);
            if (greater(cand, 0, res, 0)) res = cand;
        }

        return res;
    }

    private int[] merge(int[] nums1, int[] nums2, int k) {
        int[] res = new int[k];
        for (int i = 0, j = 0, r = 0; r < k; r++) {
            res[r] = greater(nums1, i, nums2, j) ? nums1[i++] : nums2[j++];
        }
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
        int len = 0;
        for (int i = 0; i < nums.length; i++) {
            int left = nums.length - i;
            while (left > k - len && len > 0 && res[len-1] < nums[i]) {
                len--;
            }
            if (len < k) res[len++] = nums[i];
        }
        return res;
    }
}
