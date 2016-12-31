// reference: https://discuss.leetcode.com/topic/15199/ac-o-n-solution-in-java-using-buckets-with-explanation
public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (k < 1 || t < 0) return false;
        Map<Long, Long> bucket = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            long adjustedNum = (long) nums[i] - Integer.MIN_VALUE;
            long bucketNum = adjustedNum / ((long) t + 1);
            if (bucket.containsKey(bucketNum)
                || (bucket.containsKey(bucketNum - 1) && adjustedNum - bucket.get(bucketNum - 1) <= t)
                || (bucket.containsKey(bucketNum + 1) && bucket.get(bucketNum + 1) - adjustedNum <= t))
                return true;

            if (bucket.size() >= k) {
                long removeBucket = ((long) nums[i - k] - Integer.MIN_VALUE) / ((long) t + 1);
                bucket.remove(removeBucket);
            }

            bucket.put(bucketNum, adjustedNum);
        }

        return false;
    }
}
