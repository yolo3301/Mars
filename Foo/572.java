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
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null) return false;
        if (t == null) return true;

        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        helper(s, sb1);
        helper(t, sb2);

        return sb1.toString().contains(sb2.toString());
    }

    private void helper(TreeNode n, StringBuilder sb) {
        if (n == null) {
            sb.append(",#");
            return;
        }
        sb.append(',').append(n.val);
        helper(n.left, sb);
        helper(n.right, sb);
    }
}