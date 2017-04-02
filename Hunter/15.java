public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length < 3) return res;

        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i-1]) continue;
            for (List<Integer> two : twoSum(nums, i+1, -nums[i])) {
                res.add(Arrays.asList(nums[i], two.get(0), two.get(1)));
            }
        }

        return res;
    }

    private List<List<Integer>> twoSum(int[] nums, int s, int target) {
        List<List<Integer>> res = new ArrayList<>();
        int i = s, j = nums.length - 1;
        while (i < j) {
            int sum = nums[i] + nums[j];
            if (sum < target) {
                i++;
            } else if (sum > target) {
                j--;
            } else {
                res.add(Arrays.asList(nums[i], nums[j]));
                int k = i+1;
                while (k < j && nums[k] == nums[i]) k++;
                i = k;
                k = j-1;
                while (k > i && nums[k] == nums[j]) k--;
                j = k;
            }
        }

        return res;
    }
}