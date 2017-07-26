public class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a, b) -> {
            if (a[1] != b[1]) return a[1] - b[1];
            return a[0] - b[0];
        });

        int len = 0;
        for (int i = 0; i < pairs.length; ) {
            len++;
            int currEnd = pairs[i][1];
            while (i < pairs.length && pairs[i][0] <= currEnd) i++;
        }

        return len;
    }
}