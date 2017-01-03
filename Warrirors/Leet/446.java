// reference: https://discuss.leetcode.com/topic/67012/java-15-lines-solution
public class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        int re = 0;
        HashMap<Integer, Integer>[] maps = new HashMap[A.length];
        for(int i=0; i<A.length; i++) {
            maps[i] = new HashMap<>();
            int num = A[i];
            for(int j=0; j<i; j++) {
                if((long)num-A[j]>Integer.MAX_VALUE) continue;
                if((long)num-A[j]<Integer.MIN_VALUE) continue;
                int diff = num - A[j];
                int count = maps[j].getOrDefault(diff, 0);
                // map records diff => prev sequences (include only 2 numbers)
                maps[i].put(diff, maps[i].getOrDefault(diff,0)+count+1);
                // however when count, always count the prev
                re += count;
            }
        }
        return re;
    }
}
