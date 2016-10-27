public class Solution {
    public void sortColors(int[] nums) {
        int i = 0, j = 0, k = nums.length - 1;
        while (i <= k) {
            if (nums[i] < 1) {
                swap(nums, i++, j++);
            } else if (nums[i] > 1) {
                swap(nums, i, k--);
            } else {
                i++;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
