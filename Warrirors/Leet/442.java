public class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int k : nums) {
            if (k < 0) k = -k;
            if (nums[k-1] < 0) res.add(k);
            nums[k-1] = -nums[k-1];
        }

        return res;
    }
}
