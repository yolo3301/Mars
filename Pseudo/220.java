public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums.length < 2 || t < 0 || k <= 0) return false;
        Map<Long, Long> buckets = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            long curr = (long)nums[i] - Integer.MIN_VALUE;
            long bucket = curr / ((long)t+1);
            if (buckets.containsKey(bucket)
            || buckets.containsKey(bucket+1) && buckets.get(bucket+1) - curr <= t
            || buckets.containsKey(bucket-1) && curr - buckets.get(bucket-1) <= t) {
                return true;
            }

            if (i - k >= 0) {
                long prev = (long)nums[i-k] - Integer.MIN_VALUE;
                buckets.remove(prev / ((long)t+1));
            }

            buckets.put(bucket, curr);
        }

        return false;
    }
}