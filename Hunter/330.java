public class Solution {
    public int minPatches(int[] nums, int n) {
        if (n == 0) return 0;
        // the meaning of "miss" is very important
        long miss = 1; 
        int i = 0, res = 0;
        while (miss <= n) {  // because miss is not there yet, so <=
            if (i < nums.length && nums[i] <= miss) { // because if nums[i] is miss, then it's a miss'
                miss += nums[i++];
            } else {
                res++;
                miss += miss;
            }
        }

        return res;
    }
}