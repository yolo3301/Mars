public class Solution {
    public int findKthLargest(int[] nums, int k) {
        int s = 0, e = nums.length - 1;
        int m = 0;
        while (true) {
            m = partition(nums, s, e);
            if (m == nums.length - k)
                break;
            else if (m < nums.length - k) {
                s = m + 1;
            } else {
                e = m - 1;
            }
        }

        return nums[m];
    }

    private int partition(int[] nums, int s, int e) {
        int p = nums[e];
        int j = s;
        for (int i = s; i < e; i++) {
            if (nums[i] < p) {
                if (i != j) {
                    int tmp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = tmp;
                }
                j++;
            }
        }

        nums[e] = nums[j];
        nums[j] = p;

        return j;
    }
}
