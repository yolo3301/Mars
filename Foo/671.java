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
    public int findSecondMinimumValue(TreeNode root) {
        if (root == null) return -1;
        int min = root.val;
        int res = helper(root, min);
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    private int helper(TreeNode n, int min) {
        if (n == null) return Integer.MAX_VALUE;
        if (n.val > min) return n.val;

        // n.val == min
        if (n.left != null && n.right != null) {
            return Math.min(helper(n.left, min), helper(n.right, min));
        }

        return Integer.MAX_VALUE;
    }
}