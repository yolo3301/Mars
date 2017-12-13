class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int s = 0, e = letters.length-1;
        while (s <= e) {
            // System.out.println(s + ";" + e);
            int m = s + (e - s) / 2;
            if (letters[m] <= target) {
                s = m+1;
            } else {
                if (e == m) break;
                e = m;
            }
        }

        if (s < letters.length) return letters[s];

        return letters[0];
    }
}