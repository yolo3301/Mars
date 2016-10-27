/*
Missing Number

Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.

For example,
Given nums = [0, 1, 3] return 2.
*/

public class Solution {
    public int missingNumber(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        return (nums.length + 1) * nums.length / 2 - sum;
    }
}