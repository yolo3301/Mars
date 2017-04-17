public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums.length < 2) return false;
        Map<Long, Long> bucket = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            long adjusted = (long)nums[i] - Integer.MIN_VALUE;
            long bucketNum = adjusted / ((long)t + 1);
            if (bucket.containsKey(bucketNum)
                || (bucket.containsKey(bucketNum+1) && bucket.get(bucketNum+1) - adjusted <= t)
                || (bucket.containsKey(bucketNum-1) && adjusted - bucket.get(bucketNum-1) <= t)) {
                    return true;
            }

            if (bucket.size() == k) {
                long prev = (long)nums[i-k] - Integer.MIN_VALUE;
                bucket.remove(prev / ((long)t+1));
            }

            bucket.put(bucketNum, adjusted);
        }

        return false;
    }
}