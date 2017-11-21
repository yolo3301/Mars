class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> ret = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            int j = i;
            for ( ; j > 0; j /= 10) {
                if ((j % 10 == 0 || (i % (j % 10) != 0))) break;
            }
            if (j == 0) ret.add(i);
        }
        return ret;
    }
}