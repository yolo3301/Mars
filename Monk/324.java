public class Solution {
    private Random rand = new Random();

    public void wiggleSort(int[] nums) {
        partitionK(nums, (nums.length - 1) / 2);
        
        int mid = nums[(nums.length - 1) / 2];
        System.out.println(Arrays.toString(nums));
        int l = 0, m = 0, r = nums.length - 1;

        while (m <= r) {
            if (nums[newIndex(m, nums.length)] > mid) {
                swap(nums, newIndex(l++, nums.length), newIndex(m++, nums.length));
            } else if (nums[newIndex(m, nums.length)] < mid) {
                swap(nums, newIndex(r--, nums.length), newIndex(m, nums.length));
            } else {
                m++;
            }
        }
    }

    private int newIndex(int i, int len) {
        return (2 * i + 1) % (len | 1);
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
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
        int z = rand.nextInt(e - s + 1);
        swap(nums, s + z, e);

        int p = nums[e];
        int j = s;
        for (int i = s; i < e; i++) {
            if (nums[i] <= p) {
                swap(nums, i, j++);
            }
        }

        swap(nums, j, e);

        return j;
    }
}