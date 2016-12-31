// My solution -- O(n * 2^n)
public class Solution {
    public int maxCoins(int[] nums) {
        if (nums.length == 0) return 0;
        char[] bits = new char[nums.length];
        Arrays.fill(bits, '.');
        return bt(nums, 0, bits, new HashMap<>());
    }

    private int bt(int[] nums, int used, char[] bits, Map<String, Integer> memo) {
        if (used == nums.length) {
            return 0;
        }

        String curr = new String(bits);
        //System.out.println("key:" + curr);
        if (memo.containsKey(curr)) {
            return memo.get(curr);
        }

        int left = 1, midIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            //System.out.println("used:" + used + "\tbits[" + i + "]=" + bits[i]);
            if (bits[i] != 'x') {
                //System.out.println("select mid index:" + midIndex);
                midIndex = i;
                break;
            }
        }

        int mid = nums[midIndex], res = Integer.MIN_VALUE;
        for (int j = midIndex + 1; j < nums.length; j++) {
            if (bits[j] != 'x') {
                //System.out.println("select right index:" + j + "=" + nums[j]);
                int right = nums[j];
                int v1 = left * mid * right;
                bits[midIndex] = 'x';
                int v2 = bt(nums, used + 1, bits, memo);
                res = Math.max(res, v1 + v2);
                bits[midIndex] = '.';

                left = mid;
                mid = right;
                midIndex = j;
            }
        }

        bits[midIndex] = 'x';
        int v1 = left * mid;
        int v2 = bt(nums, used + 1, bits, memo);
        res = Math.max(res, v1 + v2);
        bits[midIndex] = '.';

        memo.put(curr, res);

        return res;
    }
}


// O(n^3)
public class Solution {
    public int maxCoins(int[] nums) {
        int len = nums.length;
        if (len == 0) return 0;
        int[][] dp = new int[len][len];
        for (int l = 1; l <= len; l++) {
            for (int s = 0; s + l - 1 < len; s++) {
                for (int i = s; i <= s + l - 1; i++) {
                    int curr = nums[i] * getValue(nums, s - 1) * getValue(nums, s + l);
                    curr += i == s ? 0 : dp[s][i-1];
                    curr += i == s + l - 1 ? 0 : dp[i+1][s+l-1];
                    dp[s][s + l - 1] = Math.max(dp[s][s + l - 1], curr);
                }
            }
        }

        return dp[0][len-1];
    }

    private int getValue(int[] nums, int i) {
        if (i < 0 || i >= nums.length) {
            return 1;
        }
        return nums[i];
    }
}
