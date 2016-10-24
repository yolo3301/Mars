// O(n^2)
public class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] mem = new int[nums.length];
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            mem[i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] > nums[j]) {
                    mem[i] = Math.max(mem[i], mem[j] + 1);
                }
            }
            res = Math.max(res, mem[i]);
        }
        return res;
    }
}

// O(nlogn)
public class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) return 0;
        int[] tmp = new int[nums.length];
        tmp[0] = nums[0];
        int j = 0;

        for (int i = 1; i < nums.length; i++) {
            int index = insertIndex(0, j, tmp, nums[i]);
            tmp[index] = nums[i];
            if (index > j) j = index;
        }

        return j + 1;
    }

    private int insertIndex(int s, int e, int[] arr, int target) {
        if (s == e) {
            if (target <= arr[s]) return s;
            else return s + 1;
        }

        int m = (s + e) / 2;
        if (arr[m] == target) return m;
        else if (arr[m] < target) {
            return insertIndex(m + 1, e, arr, target);
        } else {
            return insertIndex(s, m, arr, target);
        }
    }
}
