public class Solution {
    public int[] countBits(int num) {
        int[] res = new int[num + 1];
        res[0] = 0;

        int i = 1;
        while (i <= num) {
            int j = i;
            for (int k = 0; k < j && i <= num; k++) {
                res[i++] = res[k] + 1;
            }
        }

        return res;
    }
}
