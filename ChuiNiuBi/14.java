/*
14. Longest Common Prefix

Write a function to find the longest common prefix string amongst an array of strings.
*/

public class Solution {
    public String longestCommonPrefix(String[] strs) {
        String prefix = "";
        if (strs == null || strs.length == 0)
            return prefix;
        
        prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            int minLen = Math.min(prefix.length(), strs[i].length());
            int j = 0;
            for (; j < minLen; j++) {
                if (prefix.charAt(j) != strs[i].charAt(j)) {
                    break;
                }
            }
            prefix = prefix.substring(0, j);
        }
        return prefix;
    }
}