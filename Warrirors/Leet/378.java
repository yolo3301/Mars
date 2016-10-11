import java.util.*;

public class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int x = matrix[0].length;
        if (n == 1) return matrix[0][k-1];

        Queue<AbstractMap.SimpleEntry<Integer, Integer>> q = new PriorityQueue<>(k, new Comparator<AbstractMap.SimpleEntry<Integer, Integer>>() {
            public int compare(AbstractMap.SimpleEntry<Integer, Integer> e1, AbstractMap.SimpleEntry<Integer, Integer> e2) {
                return e1.getValue() - e2.getValue();
            }
        });
        int[] index = new int[n];

        for (int i = 0; i < n; i++) {
            AbstractMap.SimpleEntry<Integer, Integer> entry = new AbstractMap.SimpleEntry<>(i, matrix[i][0]);
            q.add(entry);
        }

        int j = 0;
        int res = 0;
        while (j < k) {
            AbstractMap.SimpleEntry<Integer, Integer> entry = q.remove();
            res = entry.getValue();
            j++;
            if (index[entry.getKey()] + 1 < x) {
                AbstractMap.SimpleEntry<Integer, Integer> next = new AbstractMap.SimpleEntry<>(entry.getKey(), matrix[entry.getKey()][++index[entry.getKey()]]);
                q.add(next);
            }
        }

        return res;
    }
}
