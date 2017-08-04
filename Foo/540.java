public class Solution {
    public int singleNonDuplicate(int[] nums) {
        return helper(nums, 0, nums.length-1);
    }

    private int helper(int[] nums, int s, int e) {
        if (s == e) return nums[s];
        int m = s + (e - s) / 2;
        
        if ((m-1 < s || nums[m-1] != nums[m]) && (m+1 > e || nums[m+1] != nums[m]))
            return nums[m];

        if (m-1 >= s && nums[m-1] == nums[m]) {
            if ((m-1) % 2 == 0) {
                return helper(nums, m+1, e);
            } else {
                return helper(nums, s, m-2);
            }
        } else {
            if (m % 2 == 0) {
                return helper(nums, m+2, e);
            } else {
                return helper(nums, s, m-1);
            }
        }
    }
}