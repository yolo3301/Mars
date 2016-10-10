// Only works for sorted array
public class Solution {
    public int missingNumber(int[] nums) {
        if (nums[nums.length - 1] == nums.length - 1) return nums.length;

        int x = binarySearch(0, nums.length - 1, nums);
        return x;
    }

    private int binarySearch(int s, int e, int[] nums) {
        if (s == e) return s;

        int m = (s + e) / 2;
        if (nums[m] > m) {
            return binarySearch(s, m, nums);
        } else {
            return binarySearch(m + 1, e, nums);
        }
    }
}


public class Solution {
    public int missingNumber(int[] nums) {
        boolean hadZero = false;
        for (int i = 0; i < nums.length; i++) {
            int a = Math.abs(nums[i]);
            if (a < nums.length) {
                if (nums[a] == 0) hadZero = true;
                else nums[a] = 0 - nums[a];
            }
        }

        int j;
        for (j = 0; j < nums.length; j++) {
            if (nums[j] == 0 && !hadZero) return j;
            else if (nums[j] > 0) return j;
        }

        return j;
    }
}
