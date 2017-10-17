class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> ret = new ArrayList<>();
        for (int i = 0; i < nums.length; ) {
            int j = i+1;
            while (j < nums.length && nums[j] == nums[j-1]+1) {
                j++;
            }
            if (i+1 == j) {
                ret.add(Integer.toString(nums[i]));
            } else {
                ret.add(new StringBuilder().append(nums[i]).append("->").append(nums[j-1]).toString());
            }

            i = j;
        }

        return ret;
    }
}
