public class Solution {
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i += 2) {
            if (i + 1 < nums.length) {
                int tmp = nums[i];
                nums[i] = nums[i+1];
                nums[i+1] = tmp;
            }
        }
    }
}