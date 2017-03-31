public class Solution {
    int res = 0;
    public int reversePairs(int[] nums) {
        if (nums.length < 2) return 0;
        mergeSort(nums, 0, nums.length - 1, new int[nums.length]);
        return res;
    }

    private void mergeSort(int[] nums, int s, int e, int[] helper) {
        if (s >= e) return;

        int m = s + (e - s) / 2;
        mergeSort(nums, s, m, helper);
        mergeSort(nums, m+1, e, helper);

        int b = m+1;
        for (int a = s; a <= m; a++) {
            while (b <= e && nums[a] / 2.0 > nums[b]) b++;
            res += b - (m+1);
        }

        int i = s, j = m+1, k = s;
        while (i <= m && j <= e) {
            if (nums[i] <= nums[j]) {
                helper[k++] = nums[i++];
            } else {
                helper[k++] = nums[j++];
            }
        }

        while (i <= m) {
            helper[k++] = nums[i++];
        }

        while (j <= e) {
            helper[k++] = nums[j++];
        }

        for (k = s; k <= e; k++) nums[k] = helper[k];
    }
}