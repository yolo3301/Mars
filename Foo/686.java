class Solution {
    public int repeatedStringMatch(String A, String B) {
        for (int i = 0, j = 0; i < A.length(); i++) {
            for (j = 0; j < B.length() && A.charAt((i+j) % A.length()) == B.charAt(j); j++);
            if (j == B.length()) return (i+j) / A.length() + ((i+j) % A.length() != 0 ? 1 : 0); // need 1 more A in the end?;
        }

        return -1;
    }
}