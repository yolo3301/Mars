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
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;

        int r = 0;

        if (root.left != null && isLeaf(root.left)) {
            r += root.left.val;
        } else {
            r += sumOfLeftLeaves(root.left);
        }

        r += sumOfLeftLeaves(root.right);

        return r;
    }

    private boolean isLeaf(TreeNode node) {
        if (node == null) return false;
        return node.left == null && node.right == null;
    }
}
