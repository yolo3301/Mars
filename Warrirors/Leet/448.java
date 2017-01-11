public class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int k : nums) {
            if (k < 0) k = -k;
            if (nums[k-1] > 0) {
                nums[k-1] = -nums[k-1];
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) res.add(i+1);
        }

        return res;
    }
}
