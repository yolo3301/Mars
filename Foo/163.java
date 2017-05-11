public class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new ArrayList<>();
        if (nums.length == 0) {
            if (lower == upper) res.add(""+lower);
            else res.add(lower+"->"+upper);
            return res;
        }

        if (lower < nums[0]) {
            if (lower == nums[0]-1) {
                res.add(""+lower);
            } else {
                res.add(lower+"->"+(nums[0]-1));
            }
        }

        for (int i = 1; i < nums.length; ) {
            int j = i;
            while (j < nums.length && (nums[j] - 1 == nums[j-1] || nums[j] == nums[j-1])) {
                j++;
            }
            
            if (j == nums.length) break;

            int s = nums[j-1]+1;
            int e = nums[j]-1;
            if (s == e) {
                res.add(""+s);
            } else {
                res.add(s+"->"+e);
            }

            i = j+1;
        }

        if (upper > nums[nums.length-1]) {
            if (upper == nums[nums.length-1]+1) {
                res.add(""+upper);
            } else {
                res.add((nums[nums.length-1]+1)+"->"+upper);
            }
        }

        return res;
    }
}