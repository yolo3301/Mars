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
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        return check(root, 0, sum);
    }

    private boolean check(TreeNode node, int curr, int sum) {
        if (node == null) return false;
        if (node.left == null && node.right == null) return curr + node.val == sum;

        return check(node.left, curr + node.val, sum) || check(node.right, curr + node.val, sum);
    }
}
