// https://discuss.leetcode.com/topic/47983/java-dp-o-1-solution

public class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) return 1;

        int res = 10;
        int uniqueNumber = 9;
        int availableNumber = 9;
        while (n-- > 1 && availableNumber > 0) {
            uniqueNumber = uniqueNumber * availableNumber;
            res += uniqueNumber;
            availableNumber--;
        }

        return res;
    }
}
