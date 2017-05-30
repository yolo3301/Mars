public class Solution {
    public boolean canPermutePalindrome(String s) {
        Set<Character> set = new HashSet<>();
        for (char ch : s.toCharArray()) {
            if (set.contains(ch)) set.remove(ch);
            else set.add(ch);
        }

        return set.size() <= 1;
    }
}