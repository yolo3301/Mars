class Solution {
    public int[] anagramMappings(int[] A, int[] B) {
        Map<Integer, Integer> index = new HashMap<>();
        for (int i = 0; i < B.length; i++) {
            index.put(B[i], i);
        }

        int[] ret = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            ret[i] = index.get(A[i]);
        }

        return ret;
    }
}