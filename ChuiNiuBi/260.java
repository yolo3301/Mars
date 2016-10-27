/*
Single Number III

Given an array of numbers nums, 
in which exactly two elements appear only once and all the other elements appear exactly twice. 
Find the two elements that appear only once.

For example:

Given nums = [1, 2, 1, 3, 2, 5], return [3, 5].
*/

public class Solution {
    public int[] singleNumber(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res ^= nums[i];
        }
        
        int lastBit = res - (res & (res - 1));
        int g1 = 0, g2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] & lastBit) == 0)
                g1 ^= nums[i];
            else
                g2 ^= nums[i];
        }
        int[] ans = {g1, g2};
        return ans;
    }
}