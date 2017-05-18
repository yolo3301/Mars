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
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        return helper(root, p);
    }

    private TreeNode helper(TreeNode node, TreeNode p) {
        if (node == null) return null;
        if (node.val == p.val) {
            TreeNode q = node.right;
            if (q == null) return null;
            while (q.left != null) {
                q = q.left;
            }
            return q;
        } else if (node.val < p.val) {
            return helper(node.right, p);
        } else {
            TreeNode cand = null;
            if ((cand = helper(node.left, p)) != null) {
                return cand;
            } else {
                return node;
            }
        }
    }
}