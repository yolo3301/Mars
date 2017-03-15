public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length < 3) return res;
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) break;
            if (i > 0 && nums[i] == nums[i-1]) continue;
            for (List<Integer> l : sum(nums, i+1, nums.length - 1, -nums[i])) {
                l.add(nums[i]);
                res.add(l);
            }
        }

        return res;
    }

    private List<List<Integer>> sum(int[] nums, int s, int e, int t) {
        List<List<Integer>> res = new ArrayList<>();
        int i = s, j = e;
        while (i < j) {
            if (nums[i] + nums[j] == t) {
                List<Integer> l = new ArrayList<>();
                l.add(nums[i++]);
                l.add(nums[j--]);
                res.add(l);

                while (i > s && i < j && nums[i] == nums[i-1]) i++;
                while (j < e && i < j && nums[j] == nums[j+1]) j--;
            } else if (nums[i] + nums[j] < t) {
                i++;
            } else {
                j--;
            }
        }

        return res;
    }
}