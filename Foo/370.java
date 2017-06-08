public class Solution {
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] add = new int[length];
        int[] res = new int[length];
        for (int[] u : updates) {
            add[u[0]] += u[2]; // add when start
            if (u[1]+1 < length) add[u[1]+1] -= u[2]; // remove when after end
        }

        int sum = 0; // keep the running sum
        for (int i = 0; i < length; i++) {
            sum += add[i];
            res[i] = sum;
        }

        return res;
    }
}