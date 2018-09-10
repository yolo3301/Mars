class Solution {
    public int[] fairCandySwap(int[] A, int[] B) {
        int sum1 = 0, sum2 = 0;
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (int a : A) {
            sum1 += a;
            set1.add(a);
        }
        for (int b : B) {
            sum2 += b;
            set2.add(b);
        }

        int diff = sum1 - sum2;
        if (diff % 2 != 0) return new int[2];

        for (int a : set1) {
            // sum1-a+b = sum2-b+a => sum1-sum2=2(a-b)
            if (set2.contains(a - diff/2)) {
                return new int[]{a, a - diff/2};
            }
        }

        return new int[2];
    }
}