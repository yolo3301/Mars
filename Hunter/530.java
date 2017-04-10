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
    public int getMinimumDifference(TreeNode root) {
        traverse(root);
        return res;
    }

    private TreeNode last = null;
    private int res = Integer.MAX_VALUE;

    private void traverse(TreeNode node) {
        if (node == null) return;
        traverse(node.left);
        if (last != null) {
            res = Math.min(res, node.val - last.val);
        }
        last = node;
        traverse(node.right);
    }
}