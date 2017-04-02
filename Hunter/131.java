public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        if (s.length() == 0) return res;
        boolean[][] isPan = new boolean[s.length()][s.length()];
        List<List<String>>[] dp = new ArrayList[s.length()];

        for (int i = 0; i < s.length(); i++) {
            dp[i] = new ArrayList<>();
            for (int j = i; j >= 0; j--) {
                if (s.charAt(i) == s.charAt(j) && (j >= i-1 || isPan[j+1][i-1])) {
                    isPan[j][i] = true;
                    if (j == 0) {
                        dp[i].add(Arrays.asList(s.substring(0, i+1)));
                    } else {
                        for (List<String> prev : dp[j-1]) {
                            List<String> curr = new ArrayList<>(prev);
                            curr.add(s.substring(j, i+1));
                            dp[i].add(curr);
                        }
                    }
                }
            }
        }

        return dp[s.length()-1];
    }
}