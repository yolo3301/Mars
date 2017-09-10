class Solution {
    public int findNumberOfLIS(int[] nums) {
        int[] len = new int[nums.length];
        int[] cnt = new int[nums.length];
        int maxLen = 0;

        for (int i = 0; i < nums.length; i++) {
            len[i] = 1;
            cnt[i] = 1;
            for (int j = i-1; j >= 0; j--) {
                if (nums[j] < nums[i]) {
                    if (len[j]+1 > len[i]) {
                        len[i] = len[j]+1;
                        cnt[i] = cnt[j];
                    } else if (len[j]+1 == len[i]) {
                        cnt[i] += cnt[j];
                    }
                }
            }
            maxLen = Math.max(maxLen, len[i]);
        }

        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (len[i] == maxLen) {
                res += cnt[i];
            }
        }

        return res;
    }
}