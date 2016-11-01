/*
318. Maximum Product of Word Lengths

Given a string array words, find the maximum value of length(word[i]) * length(word[j]) where the two words do not share common letters. You may assume that each word will contain only lower case letters. If no such two words exist, return 0.

Example 1:
Given ["abcw", "baz", "foo", "bar", "xtfn", "abcdef"]
Return 16
The two words can be "abcw", "xtfn".
*/

public class Solution {
    public int maxProduct(String[] words) {
        int[] elements = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                elements[i] |= (1 << (int)(words[i].charAt(j) - 'a'));
            }
        }
        
        int maxAns = 0;
        for (int i = 0; i < elements.length - 1; i++) {
            for (int j = i; j < elements.length; j++) {
                if( (elements[i] & elements[j]) == 0 ) {
                    maxAns = Math.max(maxAns, words[i].length() * words[j].length());
                }
            }
        }
        
        return maxAns;
    }
}