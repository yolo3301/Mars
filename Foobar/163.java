class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> ret = new ArrayList<>();
        if (nums.length == 0) {
            if (lower == upper) {
                ret.add(""+lower);
            } else {
                ret.add(lower+"->"+upper);
            }

            return ret;
        }

        if (lower < nums[0]) {
            if (lower == nums[0]-1) {
                ret.add(""+lower);
            } else {
                ret.add(lower+"->"+(nums[0]-1));
            }
        }

        for (int i = 0; i < nums.length; ) {
            int j = i+1;
            while (j < nums.length && (nums[j] == nums[j-1] || nums[j]-1 == nums[j-1])) j++;

            if (j == nums.length) break;

            int rs = nums[j-1]+1;
            int re = nums[j]-1;
            if (rs == re) {
                ret.add(""+rs);
            } else {
                ret.add(rs+"->"+re);
            }

            i = j;
        }

        if (nums[nums.length-1] < upper) {
            if (nums[nums.length-1]+1 == upper) {
                ret.add(""+upper);
            } else {
                ret.add((nums[nums.length-1]+1)+"->"+upper);
            }
        }

        return ret;
    }
}
