public class Solution {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int[] res = new int[k];
        int len1 = nums1.length;
        int len2 = nums2.length;
        for (int i = Math.max(0, k-len2); i <= len1 && i <= k; i++) {
            int[] cand = merge(singleMax(nums1, i), singleMax(nums2, k-i), k);
            if (greater(cand, 0, res, 0)) res = cand;
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
        for (int i = 0, j = 0; i < nums.length; i++) {
            // it's res[j-1] because j is the next index to add
            while (j > 0 && j + nums.length - i > k && res[j-1] < nums[i])
                j--;
            if (j < k) res[j++] = nums[i];
        }
        return res;
    }

    private int[] merge(int[] nums1, int[] nums2, int k) {
        int[] res = new int[k];
        for (int i = 0, j = 0, z = 0; i < k; i++) {
            res[i] = greater(nums1, j, nums2, z) ? nums1[j++] : nums2[z++];
        }
        return res;
    }
}