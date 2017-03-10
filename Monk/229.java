public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums.length == 0) return res;
        int cand1 = nums[0], cand2 = nums[0];
        int cnt1 = 0, cnt2 = 0;
        for (int i : nums) {
            if (i == cand1) {
                cnt1++;
            } else if (i == cand2) {
                cnt2++;
            } else if (cnt1 == 0) {
                cand1 = i;
                cnt1 = 1;
            } else if (cnt2 == 0) {
                cand2 = i;
                cnt2 = 1;
            } else {
                cnt1--;
                cnt2--;
            }
        }

        cnt1 = 0;
        cnt2 = 0;
        for (int i : nums) {
            if (i == cand1) cnt1++;
            else if (i == cand2) cnt2++;
        }

        if (cnt1 > nums.length / 3) res.add(cand1);
        if (cand2 != cand1 && cnt2 > nums.length / 3) res.add(cand2);

        return res;
    }
}