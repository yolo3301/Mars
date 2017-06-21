/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode str2tree(String s) {
        if (s.length() == 0) return null;
        return helper(s);
    }

    int index = 0;
    private TreeNode helper(String s) {
        if (index >= s.length()) return null;

        // assume the current level won't start with ()
        int j = index;
        while (j < s.length() && s.charAt(j) != '(' && s.charAt(j) != ')') j++;

        int v = Integer.valueOf(s.substring(index, j));
        TreeNode curr = new TreeNode(v);

        index = j+1; // skip the () for index
        
        // If ) or end, then it means return current node
        if (j == s.length() || s.charAt(j) == ')') return curr;
        
        // Go left first
        curr.left = helper(s);

        // If after left, there is another (, then means there is right
        if (index < s.length() && s.charAt(index) == '(') {
            index++; // skip the (
            curr.right = helper(s); // go right
            index++; // skip the ) in the end
        } else if (index < s.length() && s.charAt(index) == ')') {
            // if after left, there is ), then means no right
            // skip )
            index++;
        }

        return curr;
    }
}