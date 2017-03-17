public class Solution {
    // Solve with BST
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums.length <= 1 || k == 0) return false;
        TreeMap<Long, Integer> map = new TreeMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (i - k - 1 >= 0) {
                int p = map.get((long)nums[i - k - 1]);
                if (p == 1) map.remove((long)nums[i - k - 1]);
                else map.put((long)nums[i - k - 1], p - 1);
            }
            

            Long q;
            if ((q = map.ceilingKey((long)(nums[i] - t))) != null) {
                if (q.longValue() <= (long)nums[i] + t) return true;
            }
            if ((q = map.floorKey((long)(nums[i] + t))) != null) {
                if (q.longValue() >= (long)nums[i] - t) return true;
            }

            if (map.containsKey((long)nums[i])) {
                map.put((long)nums[i], map.get((long)nums[i]) + 1);
            } else {
                map.put((long)nums[i], 1);
            }
        }

        return false;
    }
}

// better solution using bucket sort idea
public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (k == 0 || t < 0) return false;
        Map<Long, Long> bucket = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            long adjusted = (long)nums[i] - Integer.MIN_VALUE;
            long bucketNum = adjusted / ((long)t + 1);
            if (bucket.containsKey(bucketNum)
                || (bucket.containsKey(bucketNum - 1) && adjusted - bucket.get(bucketNum - 1) <= t)
                || (bucket.containsKey(bucketNum + 1) && bucket.get(bucketNum + 1) - adjusted <= t)) {
                    return true;
            }

            if (bucket.size() >= k) {
                long prev = (long)nums[i - k] - Integer.MIN_VALUE;
                bucket.remove(prev / ((long)t + 1));
            }

            bucket.put(bucketNum, adjusted);
        }

        return false;
    }
}