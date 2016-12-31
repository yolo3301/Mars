public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> res = new ArrayList<>();
        if (s.length() < 10) return res;

        Set<String> set = new HashSet<>();
        Set<String> rset = new HashSet<>();
        for (int i = 10; i <= s.length(); i++) {
            String curr = s.substring(i - 10, i);
            if (set.contains(curr)) {
                rset.add(curr);
            } else {
                set.add(curr);
            }
        }

        return new ArrayList<String>(rset);
    }
}


// An optimized solution can make match faster
// https://discuss.leetcode.com/topic/8894/clean-java-solution-hashmap-bits-manipulation
