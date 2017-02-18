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
    private TreeNode res = null;
    private int h = 0;
    public int findBottomLeftValue(TreeNode root) {
        h = height(root);
        preOrder(root, 1);

        return res.val;
    }

    private int height(TreeNode node) {
        if (node == null) return 0;
        return Math.max(height(node.left), height(node.right)) + 1;
    }

    private void preOrder(TreeNode node, int depth) {
        if (res != null || node == null) return;
        if (depth == h) {
            res = node;
            return;
        }

        preOrder(node.left, depth + 1);
        preOrder(node.right, depth + 1);
    }
}