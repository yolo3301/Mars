class Solution {
    public List<Integer> partitionLabels(String S) {
        int[] lastAppear = new int[26];
        Arrays.fill(lastAppear, -1);
        for (int i = 0; i < S.length(); i++) {
            lastAppear[S.charAt(i) - 'a'] = i;
        }

        List<Integer> ret = new ArrayList<>();
        int start = 0;
        while (start < S.length()) {
            int board = lastAppear[S.charAt(start)-'a'];
            int j = start;
            // Extend boarder
            for ( ; j <= board; j++) {
                board = Math.max(board, lastAppear[S.charAt(j)-'a']);
            }
            ret.add(j - start);
            start = j;
        }

        return ret;
    }
}