public class Solution {
    public int thirdMax(int[] nums) {
        if (nums.length == 1) return nums[0];

        long a = Long.MIN_VALUE, b = Long.MIN_VALUE, c = Long.MIN_VALUE;
        for (int i : nums) {
            if (i > a) {
                c = b;
                b = a;
                a = i;
            } else if (i == a) {
                continue;
            } else if (i > b) {
                c = b;
                b = i;
            } else if (i == b) {
                continue;
            } else if (i > c) {
                c = i;
            }
        }

        return (c == Long.MIN_VALUE) ? (int)a : (int)c;
    }
}