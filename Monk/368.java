public class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> res = new ArrayList<>();
       if (nums.length == 0) return res;

       List<Integer>[] dp = new ArrayList[nums.length];
       Arrays.sort(nums);

       dp[0] = new ArrayList<>();
       dp[0].add(nums[0]);
       res = dp[0];

       for (int i = 1; i < nums.length; i++) {
           dp[i] = new ArrayList<>();
           dp[i].add(nums[i]);
           for (int j = i - 1; j >= 0; j--) {
               if (nums[i] % nums[j] == 0) {
                   if (dp[j].size() + 1 > dp[i].size()) {
                       dp[i] = new ArrayList<Integer>(dp[j]);
                       dp[i].add(nums[i]);
                   }
               }
           }

           if (dp[i].size() > res.size()) res = dp[i];
       }

       return res;
    }
}