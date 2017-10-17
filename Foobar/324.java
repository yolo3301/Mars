class Solution {
    public void wiggleSort(int[] nums) {
        if (nums.length <= 1) return;
        partitionByMid(nums);

        int len = nums.length;
        int mid = nums[(len-1)/2];

        int i = 0, j = len-1, k = 0;
        while (k <= j) {
            if (nums[index(len, k)] > mid) {
                swap(nums, index(len, k++), index(len, i++));
            } else if (nums[index(len, k)] < mid) {
                swap(nums, index(len, k), index(len, j--));
            } else {
                k++;
            }
        }
    }

    private int index(int len, int i) {
        return (2*i + 1) % (len | 1);
    }

    private void partitionByMid(int[] nums) {
        /*int len = nums.length;
        int l = 0, r = len-1;
        while (true) {
            int p = partition(nums, l, r);
            if (p == len/2) return;
            if (p < len/2) {
                l = p+1;
            } else {
                r = p-1;
            }
        }*/
        int len = nums.length - 1;
        int pos = 0, s = 0, e = nums.length - 1;
        while (true) {
            pos = partition(nums, s, e);
            if (pos == len / 2) return;
            else if (pos > len / 2) e = pos - 1;
            else s = pos + 1;
        }
    }

    private int partition(int[] nums, int s, int e) {
        int p = nums[e];
        int j = s;
        for (int i = s; i < e; i++) {
            if (nums[i] <= p) swap(nums, i, j++);
        }
        swap(nums, j, e);

        return j;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}

