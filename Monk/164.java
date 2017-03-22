public class Solution {
    public int maximumGap(int[] nums) {
        if (nums.length < 2) return 0;
        bucketSort(nums);
        int res = 0;
        for (int i = 1; i < nums.length; i++) res = Math.max(res, nums[i] - nums[i-1]);
        return res;
    }

    private void bucketSort(int[] nums) {
        int max = nums[0];
        for (int i : nums) max = Math.max(i, max);
        int cnt = 0;
        while (max != 0) {
            cnt++;
            max /= 10;
        }

        int div = 1;
        for (int i = 0; i < cnt; i++) {
            List<Integer>[] bucket = new ArrayList[10];
            for (int j = 0; j < 10; j++) bucket[j] = new ArrayList<>();
            for (int j : nums) {
                int curr = (j / div) % 10;
                bucket[curr].add(j);
            }

            for (int j = 0, k = 0; j < 10; j++) {
                for (int v : bucket[j]) {
                    nums[k++] = v;
                }
            }

            div *= 10;
        }
    }
}