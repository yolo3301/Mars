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
    public TreeNode increasingBST(TreeNode root) {
        TreeNode[] n = helper(root);
        return n[0];
    }

    private TreeNode[] helper(TreeNode node) {
        if (node == null) return null;
        TreeNode[] l = helper(node.left);
        TreeNode[] r = helper(node.right);
        TreeNode first = node, last = node;
        if (l != null) {
            l[1].right = node;
            first = l[0];
        }
        if (r != null) {
            node.right = r[0];
            last = r[1];
        }
        return TreeNode[]{first, last};
    }
}

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
    public TreeNode increasingBST(TreeNode root) {
        return helper(root, null);
    }

    private TreeNode helper(TreeNode n, TreeNode tail) {
        if (n == null) return tail;
        TreeNode ret = helper(n.left, n);
        n.left = null;
        n.right = helper(n.right, tail);
        return ret;
    }
}