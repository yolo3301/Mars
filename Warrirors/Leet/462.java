public class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int i = 0, j = nums.length - 1;
        int cnt = 0;
        while (i < j) {
            cnt += nums[j] - nums[i];
            i++;
            j--;
        }
        return cnt;
    }
}
