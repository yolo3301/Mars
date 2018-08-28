class Solution {
    public boolean buddyStrings(String A, String B) {
        if (A.length() != B.length()) return false;
        int[] cnt = new int[26];
        boolean seenDiff = false, swapped = false;
        char got = ' ', want = ' ';
        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) == B.charAt(i)) {
                cnt[A.charAt(i) - 'a']++;
            } else {
                if (swapped) return false;
                if (seenDiff) {
                    if (B.charAt(i) != want || A.charAt(i) != got)
                        return false;
                    swapped = true;
                } else {
                    seenDiff = true;
                    got = B.charAt(i);
                    want = A.charAt(i);
                }
            }
        }

        if (seenDiff) return swapped;
        for (int i = 0; i < 26; i++) {
            if (cnt[i] > 0 && cnt[i] % 2 == 0)
                return true;
        }

        return false;
    }
}