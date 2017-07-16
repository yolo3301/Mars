public class Solution {
    public int findDerangement(int n) {
        if (n == 1) return 0;
        if (n == 2) return 1;
        int first = 0, second = 1;
        for (int i = 3; i <= n; i++) {
            int tmp = second;
            second = (int)((i-1L) * (first + second) % 1000000007);
            first = tmp;
        }
        return second;
    }
}