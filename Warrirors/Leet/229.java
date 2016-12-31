// https://discuss.leetcode.com/topic/32510/java-easy-version-to-understand
public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums.length == 0) return res;

        int cand1 = nums[0];
        int count1 = 0;
        int cand2 = nums[0];
        int count2 = 0;

        for (int i = 0; i < nums.length; i++) {
            if (cand1 == nums[i]) {
                count1++;
            } else if (cand2 == nums[i]) {
                count2++;
            } else if (count1 == 0) {
                cand1 = nums[i];
                count1 = 1;
            } else if (count2 == 0) {
                cand2 = nums[i];
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }

        int c1 = 0, c2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == cand1) c1++;
            else if (nums[i] == cand2) c2++;
        }

        if (c1 > nums.length / 3) res.add(cand1);
        if (c2 > nums.length / 3) res.add(cand2);

        return res;
    }
}
