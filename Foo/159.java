public class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if (s.length() <= 2) return s.length();
        Character c1 = null, c2 = null;
        int cnt1 = 0, cnt2 = 0, res = 0;
        for (int i = 0, j = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            if (c1 != null && curr == c1) {
                cnt1++;
            } else if (c2 != null && curr == c2) {
                cnt2++;
            } else {
                if (c1 == null) {
                    c1 = curr;
                    cnt1 = 1;
                } else if (c2 == null) {
                    c2 = curr;
                    cnt2 = 1;
                } else {
                    while (cnt1 > 0 && cnt2 > 0 && j < i) {
                         char d = s.charAt(j++);
                         if (d == c1) cnt1--;
                         else if (d == c2) cnt2--;
                    }

                    if (cnt1 == 0) {
                        c1 = curr;
                        cnt1 = 1;
                    } else if (cnt2 == 0) {
                        c2 = curr;
                        cnt2 = 1;
                    }
                }
            }

            res = Math.max(res, i - j + 1);
        }

        return res;
    }
}