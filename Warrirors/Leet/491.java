public class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        helper(res, new ArrayList<Integer>(), nums, 0);
        return res;
    }

    private void helper(List<List<Integer>> res, List<Integer> list, int[] nums, int id) {
        if (list.size() > 1) res.add(new ArrayList<Integer>(list));
        List<Integer> unique = new ArrayList<Integer>();
        for (int i = id; i < nums.length; i++) {
            if (id > 0 && nums[i] < nums[id-1]) continue; // skip non-increase
            if (unique.contains(nums[i])) continue; // skip duplicate
            unique.add(nums[i]);
            list.add(nums[i]);
            helper(res, list, nums, i+1);
            list.remove(list.size()-1);
        }
    }
}