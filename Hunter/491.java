public class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length <= 1) return res;

        List<List<Integer>>[] dp = new ArrayList[nums.length];
        Map<Integer, Integer> lastIndex = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            lastIndex.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            dp[i] = new ArrayList<>();
            Set<Integer> met = new HashSet<>();
            for (int j = i-1; j >= 0; j--) {
                if (nums[j] <= nums[i] && !met.contains(nums[j])) {
                    for (List<Integer> prev : dp[j]) {
                        List<Integer> curr = new ArrayList<>(prev);
                        curr.add(nums[i]);
                        dp[i].add(curr);
                    }
                    dp[i].add(Arrays.asList(nums[j], nums[i]));

                    met.add(nums[j]);
                }
            }
            if (i == lastIndex.get(nums[i])) {
                res.addAll(dp[i]);
            }
        }

        return res;
    }
}