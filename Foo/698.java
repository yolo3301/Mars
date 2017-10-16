class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int n : nums) sum += n;
        if (sum % k != 0) return false;

        BitSet pool = new BitSet(nums.length);
        pool.set(0, nums.length);

        return helper(pool, nums, 0, sum/k, k, new HashMap<>());
    }

    private boolean helper(BitSet pool, int[] nums, int sum, int target, int groups, Map<String, Boolean> memo) {
        String key = getKey(pool, groups);
        if (memo.containsKey(key)) return memo.get(key);
        if (groups == 0) return pool.isEmpty();

        if (sum > target) return false;
        if (sum == target) {
            return helper(pool, nums, 0, target, groups-1, memo);
        }

        boolean ret = false;
        for (int i = pool.nextSetBit(0); i >= 0; i = pool.nextSetBit(i+1)) {
            pool.clear(i);
            ret |= helper(pool, nums, sum+nums[i], target, groups, memo);
            pool.set(i);
            if (ret) break;
        }

        memo.put(key, ret);
        return ret;
    }

    private String getKey(BitSet pool, int groups) {
        return pool.toString() + ":" + Integer.toString(groups);
    }
}
