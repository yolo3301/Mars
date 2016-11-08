public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.isEmpty()) return 0;
        int[] mem = new int[triangle.size()];
        mem[0] = triangle.get(0).get(0);

        for (int i = 1; i < triangle.size(); i++) {
            int[] tmp = new int[triangle.size()];
            tmp[0] = mem[0] + triangle.get(i).get(0);
            tmp[i] = mem[i-1] + triangle.get(i).get(i);
            for (int j = 1; j < i; j++) {
                tmp[j] = Math.min(mem[j-1], mem[j]) + triangle.get(i).get(j);
            }
            mem = tmp;
        }

        int res = Integer.MAX_VALUE;
        for (int i = 0; i < mem.length; i++) {
            res = Math.min(res, mem[i]);
        }

        return res;
    }
}
