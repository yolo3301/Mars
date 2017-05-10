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
    int res = 1;
    public int longestConsecutive(TreeNode root) {
        if (root == null) return 0;
        helper(root, root.val, 1);
        return res;
    }

    private void helper(TreeNode node, int pVal, int pLen) {
        if (node == null) return;
        if (node.val == pVal+1) pLen++;
        else pLen = 1;
        res = Math.max(res, pLen);
        helper(node.left, node.val, pLen);
        helper(node.right, node.val, pLen);
    }
}