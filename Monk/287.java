// why there is a circle in the array?
// why 0 is not in the circle?
public class Solution {
    public int findDuplicate(int[] nums) {
        if (nums.length <= 1) return -1;
        int fast = nums[nums[0]], slow = nums[0];
        while (fast != slow) {
            fast = nums[nums[fast]];
            slow = nums[slow];
        }

        fast = 0;
        while (fast != slow) {
            fast = nums[fast];
            slow = nums[slow];
        }

        return fast;
    }
}