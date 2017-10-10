class Solution {
    public boolean hasAlternatingBits(int n) {
        int last = (n & 1);
        n >>= 1;
        while (n != 0) {
            int cur = (n & 1);
            if (cur == last) return false;
            last = cur;
            n >>= 1;
        }

        return true;
    }
}