public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums.length == 0) return res;
        int cnt1 = 0, cand1 = nums[0], cnt2 = 0, cand2 = nums[0];
        for (int i : nums) {
            if (i == cand1) cnt1++;
            else if (i == cand2) cnt2++;
            else if (cnt1 == 0) {
                cnt1 = 1;
                cand1 = i;
            } else if (cnt2 == 0) {
                cnt2 = 1;
                cand2 = i;
            } else {
                cnt1--;
                cnt2--;
            }
        }

        cnt1 = 0;
        cnt2 = 0;
        for (int i : nums) {
            if (i == cand1) cnt1++;
            if (i == cand2) cnt2++;
        }

        if (cnt1 > nums.length / 3) res.add(cand1);
        if (cand1 != cand2 && cnt2 > nums.length / 3) res.add(cand2);

        return res;
    }
}