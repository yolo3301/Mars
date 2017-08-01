public class Solution {
    public String longestPalindrome(String s) {
        if (s.length() <= 1) return s;

        String res = null;
        for (int i = 0; i < s.length(); i++) {
            String cand1 = expand(s, i, false);
            String cand2 = expand(s, i, true);
            String cand = cand1.length() > cand2.length() ? cand1 : cand2;
            if (res == null || cand.length() > res.length())
                res = cand;
        }

        return res;
    }

    private String expand(String s, int mid, boolean flag) {
        int i = mid-1, j = mid+1;
        if (flag) {
            i = mid;
        }
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }
        return s.substring(i+1, j);
    }
}