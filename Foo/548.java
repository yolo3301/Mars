public class Solution {
    public boolean splitArray(int[] nums) {
        int[] sums = new int[nums.length];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            sums[i] = sum;
        }

        for (int j = 3; j < nums.length - 3; j++) {
            Set<Integer> cand = new HashSet<>();
            for (int i = 1; i < j-1; i++) {
                if (sums[i-1] == sums[j-1] - sums[i])
                    cand.add(sums[i-1]);
            }
            for (int k = j+2; k < nums.length-1; k++) {
                if (sums[k-1]-sums[j] == sums[nums.length-1]-sums[k] && cand.contains(sums[k-1]-sums[j]))
                    return true;
            }
        }

        return false;
    }
}