/*
3sum closest
*/

public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 3)    return Integer.MIN_VALUE;
        Arrays.sort(nums);
        
        int n = nums.length;
        int sum = nums[0] + nums[1] + nums[n-1];
        for (int i = 0; i < n-2; i++) {
            int j = i + 1;
            int k = n - 1;
            while (j < k) {
                int tmp = nums[i] + nums[j] + nums[k];
                if (Math.abs(tmp - target) < Math.abs(sum - target)) {
                    sum = tmp;
                }
                if (tmp < target)   j++;
                else    k--;
            }
        }
        
        return sum;
    }
}