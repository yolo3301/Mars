/*
357. Count Numbers with Unique Digits

Given a non-negative integer n, count all numbers with unique digits, x, where 0 ≤ x < 10n.

Example:
Given n = 2, return 91. (The answer should be the total numbers in the range of 0 ≤ x < 100, excluding [11,22,33,44,55,66,77,88,99])
*/

public class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if (n <= 0)
            return 1;
        
        int[] ans = new int[n+1];
        ans[0] = 1;
        ans[1] = 9;
        for (int i = 2; i < n+1; i++) {
            ans[i] = ans[i-1] * (9 - i + 2);
        }
        int sum = 0;
        for (int num : ans) 
            sum += num;
        
        return sum;
    }
}