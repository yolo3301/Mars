public class Solution {
    public void wiggleSort(int[] nums) {
        if (nums.length < 2) return;
        partitionByMid(nums);

        int len = nums.length;
        int mid = nums[(len-1)/2];
        int i = 0, k = 0, j = nums.length - 1;
        while (k <= j) {
            if (nums[newIndex(len, k)] > mid) {
                swap(nums, newIndex(len, k++), newIndex(len, i++));
            } else if (nums[newIndex(len, k)] < mid) {
                swap(nums, newIndex(len, k), newIndex(len, j--));
            } else {
                k++;
            }
        }
    }

    private int newIndex(int len, int i) {
        return (2*i+1) % (len|1);
    }

    private void partitionByMid(int[] nums) {
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
        int pivot = nums[e];
        int j = s;
        for (int i = s; i < e; i++) {
            if (nums[i] <= pivot) swap(nums, i, j++);
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