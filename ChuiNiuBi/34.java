/*
Search for a Range

Given a sorted array of integers, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

For example,
Given [5, 7, 7, 8, 8, 10] and target value 8,
return [3, 4].
*/

public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        res[0] = -1;
        res[1] = -1;
        
        if (nums == null || nums.length == 0 || target < nums[0] || target > nums[nums.length - 1])
            return res;
        
        res[0] = findMostLeft(nums, target);
        res[1] = findMostRight(nums, target);
        
        return res;
    }
    
    private int findMostLeft(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l + 1 < r) {
            int m = l + (r - l) / 2;
            if (nums[m] == target) {
                r = m;
            } else if (nums[m] < target) {
                l = m;
            } else {
                r = m;
            }
        }
        if (nums[l] == target)
            return l;
        if (nums[r] == target)
            return r;
        return -1;
    }
    
    private int findMostRight(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l + 1 < r) {
            int m = l + (r - l) / 2;
            if (nums[m] == target) {
                l = m;
            } else if (nums[m] < target) {
                l = m;
            } else {
                r = m;
            }
        }
        if (nums[r] == target)
            return r;
        if (nums[l] == target)
            return l;
        return -1;
    }
}