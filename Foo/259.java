public class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        Arrays.sort(nums);
        int res = 0;
        for (int i = 0; i < nums.length-2; i++) {
            int j = i+1, k = nums.length-1, t = target - nums[i];
            while (j < k) {
                if (nums[j] + nums[k] < t) {
                    res += k - j;
                    j++;
                } else {
                    k--;
                }
            }
        }

        return res;
    }
}