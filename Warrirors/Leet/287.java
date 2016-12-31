// reference: https://discuss.leetcode.com/topic/25913/my-easy-understood-solution-with-o-n-time-and-o-1-space-without-modifying-the-array-with-clear-explanation
public class Solution {
    public int findDuplicate(int[] nums) {
        if (nums.length > 1) {
            int slow = nums[0];
            int fast = nums[nums[0]];
            while (slow != fast) {
                slow = nums[slow];
                fast = nums[nums[fast]];
            }

            fast = 0;
            while (slow != fast) {
                slow = nums[slow];
                fast = nums[fast];
            }

            return slow;
        }

        return -1;
    }
}
