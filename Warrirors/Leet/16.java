public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int res = 0, dist = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 2; i++) {
            int currRes = 0, currDist = Integer.MAX_VALUE;
            int j = i + 1, k = nums.length - 1;
            while (j < k) {
                int curr = nums[i] + nums[j] + nums[k];
                int tmpDist = Math.abs(curr - target);
                if (tmpDist <= currDist) {
                    currDist = tmpDist;
                    currRes = curr;
                }

                if (curr < target) {
                    j++;
                } else if (curr > target) {
                    k--;
                } else {
                    return target;
                }
            }

            if (currDist < dist) {
                dist = currDist;
                res = currRes;
            }
        }

        return res;
    }
}
