class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        if (nums.length < 3) return 0;
        Arrays.sort(nums);

        int ret = 0;

        for (int i = 0; i < nums.length-2; i++) {
            int j = i+1, k = nums.length-1;
            while (j < k) {
                int cur = nums[i]+nums[j]+nums[k];
                if (cur >= target) {
                    k--;
                } else {
                    ret += k-j;
                    j++;
                }
            }
        }

        return ret;
    }
}
