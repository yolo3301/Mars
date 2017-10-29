class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);

        int low = 0, high = nums[nums.length-1] - nums[0];

        while (low < high) {
            int m = low + (high - low) / 2;
            // Sliding window count # of pairs less than 'm'
            int left = 0, count = 0;
            for (int right = 0; right < nums.length; right++) {
                while (nums[right] - nums[left] > m) left++;
                count += right - left;
            }

            if (count >= k) high = m;
            else low = m+1;
        }

        return low;
    }
}
