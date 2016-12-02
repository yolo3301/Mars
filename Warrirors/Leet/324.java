public class Solution {
    public void wiggleSort(int[] nums) {
        int len = nums.length;
        partitionK(nums, (len-1)/2);
        int m = nums[(len-1)/2];

        int i = 0, j = 0, k = nums.length - 1;
        while (j <= k) {
            if (nums[newIndex(j, len)] > m) {
                swap(newIndex(j, len), newIndex(i, len), nums);
                j++;
                i++;
            } else if (nums[newIndex(j, len)] < m) {
                swap(newIndex(j, len), newIndex(k, len), nums);
                k--;
            } else {
                j++;
            }
        }
    }

    private void swap(int i, int j, int[] nums) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    private int newIndex(int i, int len) {
        return (2 * i + 1) % (len | 1);
    }

    private void partitionK(int[] nums, int k) {
        int s = 0, e = nums.length - 1;
        int p = 0;
        while (s < e) {
            p = partition(nums, s, e);
            if (p == k) break;
            else if (p > k) e = p - 1;
            else s = p + 1;
        }
    }

    private int partition(int[] nums, int s, int e) {
        if (s == e) return s;
        int p = nums[e];
        int j = s;
        for (int i = s; i < e; i++) {
            if (nums[i] <= p) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
                j++;
            }
        }

        nums[e] = nums[j];
        nums[j] = p;

        return j;
    }
}
