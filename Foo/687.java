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
    public int longestUnivaluePath(TreeNode root) {
        helper(root);
        return Math.max(0, res-1);
    }

    int res = 0;

    private int helper(TreeNode node) {
        if (node == null) return 0;

        int l = helper(node.left);
        int r = helper(node.right);

        int cand = 1, curr = 1;
        if (node.left != null && node.left.val == node.val) {
            cand += l;
            curr = Math.max(curr, 1 + l);
        }

        if (node.right != null && node.right.val == node.val) {
            cand += r;
            curr = Math.max(curr, 1 + r);
        }

        res = Math.max(res, cand);
        return curr;
    }
}