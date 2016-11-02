/*
Next Permutation 

Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

The replacement must be in-place, do not allocate extra memory.

Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1
*/

public class Solution {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length == 0)
            return;
            
        int k = -1, l = -1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] < nums[i+1])
                k = i;
        }
        if (k == -1) {
            Arrays.sort(nums);
            return;
        }
            
        for (int i = 0; i < nums.length; i++) {
            if (i != k && nums[i] > nums[k])
                l = i;
        }
        
        int tmp = nums[l];
        nums[l] = nums[k];
        nums[k] = tmp;
        
        int start = k + 1, end = nums.length - 1;
        while (start < end) {
            tmp = nums[start];
            nums[start++] = nums[end];
            nums[end--] = tmp;
        }
    }
}