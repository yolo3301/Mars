// slightly more efficient solution https://discuss.leetcode.com/topic/5999/bucket-sort-java-solution-with-explanation-o-n-time-and-space
public class Solution {
    public int maximumGap(int[] nums) {
        if (nums.length <= 1) return 0;
        bucketSort(nums);

        int res = 0;
        for (int i = 1; i < nums.length; i++) {
            res = Math.max(res, nums[i] - nums[i-1]);
        }

        return res;
    }

    private void bucketSort(int[] nums) {
        int max = 0;
        for (int num : nums) max = Math.max(max, num);

        if (max == 0) return;
        int nc = 0;
        while (max > 0) {
            max /= 10;
            nc++;
        }

        int div = 1;
        while (nc > 0) {
            List<Integer>[] bucket = new List[10];
            for (int i = 0; i < 10; i++)
                bucket[i] = new ArrayList<Integer>();

            for (int num : nums) {
                int curr = (num / div) % 10;
                bucket[curr].add(num);
            }

            int j = 0;
            for (List<Integer> b : bucket) {
                for (Integer n : b)
                    nums[j++] = n;
            }

            div *= 10;
            nc--;
        }
    }
}
