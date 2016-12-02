/*
Generate Parentheses

Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]

*/

public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList();
        if (n == 0)
            return res;
            
        helper(n, 0, 0, "", res);
        return res;
    }
    
    public void helper(int n, int left, int right, String paren, List<String> res) {
        if (left == n && right == n) {
            res.add(paren);
            return;
        }
        
        if (left < n) {
            helper(n, left+1, right, paren + "(", res);
        }
        
        if (right < left) {
            helper(n, left, right+1, paren + ")", res);
        }
    }
}