/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode pruneTree(TreeNode root) {
        boolean r = hasOne(root);
        if (!r) return null;

        return root;
    }

    private boolean hasOne(TreeNode node) {
        if (node == null) return false;
        boolean l = hasOne(node.left);
        boolean r = hasOne(node.right);
        if (!l) node.left = null;
        if (!r) node.right = null;
        return (l || r || node.val == 1);
    }
}