// https://discuss.leetcode.com/topic/61324/clear-explanation-8ms-binary-search-java
public class Solution {
    public int splitArray(int[] nums, int m) {
        long sum = 0;
        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
            sum += num;
        }

        if (m == 1) return (int) sum;

        long s = max, e = sum;
        while (s < e) {
            long mid = (s + e) / 2;
            if (valid(nums, m, mid)) {
                e = mid;
            } else {
                s = mid + 1;
            }
        }

        return (int) s;
    }

    private boolean valid(int[] nums, int m, long mid) {
        long sum = 0;
        int count = 1;  // important !! because initially, there is already one subarray
        for (int num : nums) {
            sum += num;
            if (sum > mid) {
                sum = num;
                count++;
                if (count > m) return false;
            }
        }
        return true;
    }
}

// My original solution
public class Solution {
    public int splitArray(int[] nums, int m) {
        int[][] memo = new int[nums.length][m+1];
        int[] sums = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            Arrays.fill(memo[i], -1);
            if (i == 0) sums[0] = nums[0];
            else sums[i] = sums[i-1] + nums[i];
        }
        return find(nums, 0, 1, m, memo, sums);
    }

    private int find(int[] nums, int index, int n, int m, int[][] memo, int[] sums) {
        if (memo[index][n] >= 0) return memo[index][n];
        if (n == m) {
            memo[index][n] = index == 0 ? sums[nums.length - 1] : sums[nums.length - 1] - sums[index - 1];
            return memo[index][n];
        }

        int sum = 0;
        int res = Integer.MAX_VALUE;
        for (int i = index; i < nums.length - (m - n); i++) {
            sum += nums[i];
            int next = find(nums, i + 1, n + 1, m, memo, sums);
            res = Math.min(res, Math.max(sum, next));
        }

        memo[index][n] = res;

        return res;
    }
}
