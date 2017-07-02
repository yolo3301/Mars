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
    public String tree2str(TreeNode t) {
        if (t == null) return "";
        String l = tree2str(t.left);
        String r = tree2str(t.right);
        
        if (l.length() == 0 && r.length() == 0)
            return Integer.toString(t.val);
        
        if (l.length() == 0)
            return t.val + "()(" + r + ")";

        if (r.length() == 0)
            return t.val + "(" + l + ")";

        return t.val + "(" + l + ")(" + r + ")";
    }
}