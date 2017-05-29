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
    public int closestValue(TreeNode root, double target) {
        helper(root, target);
        return res;
    }

    double minDiff = Double.MAX_VALUE;
    int res = -1;

    private void helper(TreeNode node, double target) {
        if (node == null) return;
        if (target == node.val) {
            minDiff = 0;
            res = node.val;
            return;
        }

        double diff = Math.abs((int)node.val - target);
        if (diff < minDiff) {
            minDiff = diff;
            res = node.val;
        }

        if (target < node.val) {
            helper(node.left, target);
        } else {
            helper(node.right, target);
        }
    }
}