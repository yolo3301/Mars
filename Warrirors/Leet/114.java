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
    public void flatten(TreeNode root) {
        flat(root);
    }

    private TreeNode flat(TreeNode node) {
        if (node == null) return null;
        if (node.left == null && node.right == null) return node;
        TreeNode l = flat(node.left);
        TreeNode r = flat(node.right);

        if (node.left != null && l != null) {
            TreeNode tmp = node.right;
            node.right = node.left;
            l.right = tmp;
            node.left = null;
        }

        if (r == null) {
            return l;
        } else {
            return r;
        }
    }
}
