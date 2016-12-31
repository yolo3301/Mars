public class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes.length == 0) return 0;
        Arrays.sort(envelopes, new Comparator<int[]>() {
            public int compare(int[] v1, int[] v2) {
                if (v1[0] != v2[0]) return v1[0] - v2[0];
                // if width are the same
                // sort height in descending !!!
                // Why? - because if width are the same, bigger height won't fit
                // sort in descending to make longest increasing subseq algo work
                else return v2[1] - v1[1];
            }
        });

        int len = 0;
        int[] dp = new int[envelopes.length];
        for (int[] envelope : envelopes) {
            int index = Arrays.binarySearch(dp, 0, len, envelope[1]);

            if (index < 0)
                index = -(index+1);

            dp[index] = envelope[1];
            if (index == len)
                len++;
        }

        return len;
    }
}
