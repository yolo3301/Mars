/*
Single Number II

Given an array of integers, every element appears three times except for one. 
Find that single one.

without using extra memory
*/

public class Solution {
    public int singleNumber(int[] nums) {
        if (nums == null || nums.length == 0)
            return -1;
        
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            int count = 0;
            for (int j = 0; j < nums.length; j++) {
                count += (nums[j] >> i) & 1;
                count %= 3;
            }
            if (count != 0)
                ans |= (1 << i);
        }
        return ans;
    }
}