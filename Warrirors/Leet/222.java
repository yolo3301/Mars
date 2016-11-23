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
        if (root == null) return 0;

        int h = height(root);

        if (h == 1) return 1;

        int rh = height(root.right);

        if (rh == h - 1) {
            // total complete left tree with h - 1 height
            // 1 root + left complete tree (1 << h-1) - 1 = 1 << h-1
            return (1 << h - 1) + countNodes(root.right);
        } else {
            // rh == h - 2
            // total complete right tree with h - 2 height
            // 1 root + left complete tree (1 << h-2) - 1 = 1 << h-2
            return (1 << h - 2) + countNodes(root.left);
        }
    }

    private int height(TreeNode root) {
        int h = 0;
        TreeNode n = root;
        while (n != null) {
            h++;
            n = n.left;
        }
        return h;
    }
}
