public class Solution {
    public int candy(int[] ratings) {
        if (ratings.length == 0) return 0;
        int[] cs = new int[ratings.length];
        Arrays.fill(cs, 1);
        for (int i = 1; i < cs.length; i++) {
            if (ratings[i] > ratings[i-1]) {
                cs[i] = cs[i-1] + 1;
            }
        }

        int res = 0;
        for (int i = cs.length - 1; i >= 0; i--) {
            if (i < cs.length - 1 && ratings[i] > ratings[i+1]) {
                cs[i] = Math.max(cs[i], cs[i+1] + 1);
            }
            res += cs[i];
        }

        return res;
    }
}
