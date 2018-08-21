class Solution {
    public List<List<Integer>> largeGroupPositions(String S) {
        List<List<Integer>> ret = new ArrayList<>();
        for (int i = 0; i < S.length(); ) {
            int j = i;
            char c = S.charAt(i);
            while (j < S.length() && S.charAt(j) == c) j++;
            if (j - i >= 3) {
                ret.add(Arrays.asList(i, j-1));
            }

            i = j;
        }

        return ret;
    }
}