class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        Arrays.sort(nums);
        int res = 0;
        for (int i = 0; i < nums.length-2; i++) {
            int j = i+1, k = nums.length-1;
            while (j < k) {
                int curr = nums[i] + nums[j] + nums[k];
                if (curr < target) {
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