public class Solution {
    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    private int mergeSort(int[] nums, int s, int e) {
        if (s >= e) return 0;

        int m = s + (e - s) / 2;

        int cnt = mergeSort(nums, s, m) + mergeSort(nums, m + 1, e);

        int j = m + 1;
        for (int i = s; i <= m; i++) {
            while (j <= e && nums[i] / 2.0 > nums[j]) {
                j++;
            }
            cnt += j - (m + 1);
        }

        int[] temp = new int[e - s + 1];
        int a = s, b = m + 1, c = 0;
        while (a <= m && b <= e) {
            if (nums[a] <= nums[b]) {
                temp[c++] = nums[a++];
            } else {
                temp[c++] = nums[b++];
            }
        }
        while (a <= m) {
            temp[c++] = nums[a++];
        }
        while (b <= e) {
            temp[c++] = nums[b++];
        }
        for (int i = 0; i < temp.length; i++) {
            nums[s+i] = temp[i];
        }

        return cnt;
    }
}