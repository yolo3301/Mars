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
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        res.add(root.val);
        leftBoundry(root.left, res);
        leaves(root.left, res);
        leaves(root.right, res);
        rightBoundry(root.right, res);
        return res;
    }

    private void leftBoundry(TreeNode node, List<Integer> res) {
        if (node == null || (node.left == null && node.right == null))
            return;
        res.add(node.val);
        if (node.left != null) leftBoundry(node.left, res);
        else leftBoundry(node.right, res);
    }

    private void rightBoundry(TreeNode node, List<Integer> res) {
        if (node == null || (node.left == null && node.right == null))
            return;
        if (node.right != null) rightBoundry(node.right, res);
        else rightBoundry(node.left, res);
        res.add(node.val);
    }

    private void leaves(TreeNode node, List<Integer> res) {
        if (node == null) return;
        if (node.left == null && node.right == null) {
            res.add(node.val);
            return;
        }
        leaves(node.left, res);
        leaves(node.right, res);
    }
}