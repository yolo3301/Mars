class Solution {
    public int countPrimeSetBits(int L, int R) {
        Set<Integer> primes = new HashSet<>(Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29 ));
        int ret = 0;
        for (int i = L; i <= R; i++) {
            if (primes.contains(countBit(i)))
                ret++;
        }
        return ret;
    }

    private int countBit(int n) {
        int ret = 0;
        while (n > 0) {
            ret += (n & 1);
            n >>= 1;
        }
        return ret;
    }
}