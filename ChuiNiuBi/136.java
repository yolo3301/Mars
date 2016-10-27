/*
Single Number

Given an array of integers, every element appears twice except for one. 
Find that single one.
*/

public class Solution {
    public int singleNumber(int[] nums) {
        if (nums == null || nums.length == 0)
            return -1;
            
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            ans ^= nums[i];
        }
        return ans;
    }
}