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
    public int countNodes(TreeNode root) {
        int h = height(root);
        if (h == 0 || h == 1) return h;

        int rightHeight = height(root.right);
        // if right height is = h - 1, then left subtree is a full tree
        // else right subtree is a full tree

        if (rightHeight == h - 1) {
            return (1 << h - 1) + countNodes(root.right);
        } else {
            return (1 << h - 2) + countNodes(root.left);
        }
    }

    private int height(TreeNode node) {
        if (node == null) return 0;
        TreeNode p = node;
        int h = 0;
        while (p != null) {
            h++;
            p = p.left;
        }

        return h;
    }
}