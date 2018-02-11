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
    TreeNode prev = null;
    int ret = Integer.MAX_VALUE;
    public int minDiffInBST(TreeNode root) {
        traverse(root);
        return ret;
    }

    private void traverse(TreeNode node) {
        if (node == null) return;
        traverse(node.left);
        if (prev != null) {
            ret = Math.min(ret, node.val - prev.val);
        }
        prev = node;
        traverse(node.right);
    }
}