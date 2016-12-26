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
    private int res = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        find(root);
        return res;
    }

    private int find(TreeNode node) {
        if (node == null) return 0;
        int left = find(node.left);
        int right = find(node.right);

        int currMax = Math.max(Math.max(left, right) + node.val, node.val);
        res = Math.max(res, Math.max(currMax, left + right + node.val));

        return currMax;
    }
}
