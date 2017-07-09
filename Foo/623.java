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
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if (d == 1) {
            TreeNode r = new TreeNode(v);
            r.left = root;
            return r;
        }

        helper(root, 1, v, d);
        return root;
    }

    private void helper(TreeNode node, int depth, int v, int d) {
        if (node == null) return;
        if (depth == d-1) {
            TreeNode l = new TreeNode(v);
            l.left = node.left;
            node.left = l;
            TreeNode r = new TreeNode(v);
            r.right = node.right;
            node.right = r;
            return;
        }

        helper(node.left, depth+1, v, d);
        helper(node.right, depth+1, v, d);
    }
}