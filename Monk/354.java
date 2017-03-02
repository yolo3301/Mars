public class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes.length <= 1) return envelopes.length;
        Arrays.sort(envelopes, new Comparator<int[]>() {
            public int compare(int[] v1, int[] v2) {
                if (v1[0] == v2[0]) return v2[1] - v1[1];
                return v1[0] - v2[0];
            }
        });

        int[] hs = new int[envelopes.length];
        for (int i = 0; i < envelopes.length; i++) {
            hs[i] = envelopes[i][1];
        }

        return lengthOfLIS(hs);
    }

    public int lengthOfLIS(int[] nums) {
        if (nums.length <= 1) return nums.length;
        int[] seq = new int[nums.length];
        int len = 0;

        for (int i = 0; i < nums.length; i++) {
            int idx = insert(seq, 0, len - 1, nums[i]);
            if (idx >= len) {
                seq[len++] = nums[i];
            } else {
                seq[idx] = nums[i];
            }
        }

        return len;
    }

    private int insert(int[] seq, int s, int e, int target) {
        if (s > e) return s;

        int m = s + (e - s) / 2;
        if (target <= seq[m]) {
            if (m - 1 < s || seq[m - 1] < target) return m;
            else return insert(seq, s, m - 1, target);
        } else {
            return insert(seq, m + 1, e, target);
        }
    }
}