class Solution {
    public int[] shortestToChar(String S, char C) {
        List<Integer> loc = new ArrayList<>();
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == C) {
                loc.add(i);
            }
        }

        int j = 0;
        int[] ret = new int[S.length()];
        for (int i = 0; i < S.length(); i++) {
            if (j < loc.size()-1 && Math.abs(i - loc.get(j)) >= Math.abs(i - loc.get(j+1))) {
                j++;
            }
            ret[i] = Math.abs(i - loc.get(j));
        }

        return ret;
    }
}