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
    private boolean result = true;

    public boolean isBalanced(TreeNode root) {
        height(root);
        return result;
    }

    private int height(TreeNode node) {
        if (node == null) return 0;
        int l = height(node.left);
        int r = height(node.right);

        if (Math.abs(l - r) > 1) result = false;
        return Math.max(l, r) + 1;
    }
}
