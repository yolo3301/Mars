class Solution {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int len = nums.length;
        int[] sum = new int[len+1];
        int[] left = new int[len];
        int[] right = new int[len];
        
        for (int i = 0; i < len; i++) sum[i+1] = sum[i] + nums[i];

        // Cal left side, for ending index i, the max sum K starting index
        for (int i = k, total = sum[k]-sum[0]; i < len; i++) {
            if (sum[i+1] - sum[i-k+1] > total) {
                left[i] = i-k+1;
                total = sum[i+1] - sum[i-k+1];
            } else {
                left[i] = left[i-1];
            }
        }

        // Cal right side, for starting index i, the max sum K starting index
        right[len-k] = len-k;
        for (int i = len-k-1, total = sum[len] - sum[len-k]; i >= 0; i--) {
            if (sum[i+k] - sum[i] > total) {
                right[i] = i;
                total = sum[i+k] - sum[i];
            } else {
                right[i] = right[i+1];
            }
        }

        // Fix mid K window, find max from left and right
        int[] res = new int[3];
        int cand = 0;
        for (int i = k; i + 2 * k <= len; i++) {
            int curr = (sum[left[i-1]+k] - sum[left[i-1]]) + (sum[right[i+k]+k] - sum[right[i+k]]) + (sum[i+k]-sum[i]);
            if (curr > cand) {
                cand = curr;
                res[0] = left[i-1];
                res[1] = i;
                res[2] = right[i+k];
            }
        }

        return res;
    }
}
