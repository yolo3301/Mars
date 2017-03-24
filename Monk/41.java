public class Solution {
    public int firstMissingPositive(int[] nums) {
        if (nums.length == 0) return 1;
        int pos = partition(nums);

        for (int i = pos; i < nums.length; i++) {
            if (pos + nums[i] - 1 < nums.length && i != pos + nums[i] - 1
                && nums[i] != nums[pos + nums[i] - 1]) {
                swap(nums, i, pos + nums[i] - 1);
                i--;
            }
        }

        for (int i = pos; i < nums.length; i++) {
            if (i != pos + nums[i] - 1) return i - pos + 1;
        }

        return nums.length - pos + 1;
    }

    private int partition(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= 0) {
                swap(nums, i, j++);
            }
        }

        return j;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}