class Solution {
    public void nextPermutation(int[] nums) {
        int s = -1;
        for (int i = nums.length-1; i > 0; i--) {
            if (nums[i] <= nums[i-1]) continue;
            s = i-1;
            break;
        }

        if (s == -1) {
            reverse(nums, 0, nums.length-1);
            return;
        }

        for (int i = nums.length-1; i > s; i--) {
            if (nums[i] > nums[s]) {
                swap(nums, i, s);
                break;
            }
        }

        reverse(nums, s+1, nums.length-1);
    }

    private void reverse(int[] nums, int i, int j) {
        while (i < j) {
            swap(nums, i++, j--);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
