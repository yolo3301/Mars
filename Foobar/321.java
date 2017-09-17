class Solution {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int[] res = new int[k];
        for (int i = Math.max(0, k - nums2.length); i <= Math.min(k, nums1.length); i++) {
            int[] part1 = findMax(nums1, i);
            int[] part2 = findMax(nums2, k-i);
            int[] cand = mergeMax(part1, part2, i, k-i);
            if (isGreater(cand, res)) res = cand;
        }

        return res;
    }

    // Find k to form max
    private int[] findMax(int[] nums, int k) {
        int[] res = new int[k];
        int idx = 0;
        for (int i = 0; i < nums.length; i++) {
            while (idx > 0 && nums.length-i > k - idx && nums[i] > res[idx-1]) {
                idx--;
            }

            if (idx < k)
                res[idx++] = nums[i];
        }

        return res;
    }

    private int[] mergeMax(int[] nums1, int[] nums2, int m, int n) {
        int[] res = new int[m+n];
        int i = 0, j = 0, k = 0;
        while (i < m || j < n) {
            if (i == m) res[k++] = nums2[j++];
            else if (j == n) res[k++] = nums1[i++];
            // Important! can't just compare the current number
            else if (greater(nums1, i, nums2, j)) res[k++] = nums1[i++];
            else res[k++] = nums2[j++];
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

    private boolean isGreater(int[] nums1, int[] nums2) {
        int i = 0, j = 0;
        while (i < nums1.length && j < nums2.length && nums1[i] == nums2[j]) {
            i++;
            j++;
        }

        return j == nums2.length || (i < nums1.length && nums1[i] > nums2[j]);
    }
}