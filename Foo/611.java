public class Solution {
    public int triangleNumber(int[] nums) {
        int res = 0;
        Arrays.sort(nums);
        for (int i = nums.length-1; i > 1; i--) {
            int l = 0, r = i-1;
            while (l < r) {
                if (nums[l] + nums[r] > nums[i]) {
                    res += r - l;
                    r--;
                } else {
                    l++;
                }
            }
        }
        return res;
    }
}