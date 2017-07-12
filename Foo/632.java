public class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        if (nums.size() == 1) return new int[]{nums.get(0).get(0), nums.get(0).get(0)};

        int[] cand = new int[]{Integer.MIN_VALUE, Integer.MAX_VALUE};
        TreeSet<int[]> bst = new TreeSet<>((a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0];
            else return a[1] - b[1];
        });
        for (int i = 0; i < nums.size(); i++) {
            bst.add(new int[]{nums.get(i).get(0), i, 0});
        }

        while(true) {
            int[] min = bst.first();
            int[] max = bst.last();
            long diff = (long)max[0] - min[0];
            long candDiff = (long)cand[1] - cand[0];
            if (diff < candDiff) {
                cand = new int[]{min[0], max[0]};
            }

            bst.remove(min);

            if (nums.get(min[1]).size() == min[2]+1)
                break;
            
            bst.add(new int[]{nums.get(min[1]).get(min[2]+1), min[1], min[2]+1});
        }

        return cand;
    }
}