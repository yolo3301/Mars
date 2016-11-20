public class Solution {
    public void nextPermutation(int[] nums) {
        if (nums.length <= 1) return;

        int p = nums.length - 2;
        while (p >= 0 && nums[p] >= nums[p+1]) p--;

        if (p < 0) {
            Arrays.sort(nums);
            return;
        }

        Arrays.sort(nums, p + 1, nums.length);
        int index = search(nums, p + 1, nums.length - 1, nums[p]);
        swap(nums, p, index);
    }

    private void swap(int[] nums, int i, int j) {
        if (i == j) return;
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    private int search(int[] nums, int s, int e, int target) {
        if (s > e) return -1;
        if (s == e && nums[s] > target) return s;

        int m = (s + e) / 2;
        if (nums[m] <= target) {
            return search(nums, m + 1, e, target);
        } else {
            return search(nums, s, m, target);
        }
    }
}
