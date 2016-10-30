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
    private int res = 0;
    public int sumNumbers(TreeNode root) {
        if (root == null) return 0;
        sum(root, 0);
        return res;
    }

    private void sum(TreeNode node, int curr) {
        if (node == null) return;
        int v = curr * 10 + node.val;
        if (node.left == null && node.right == null) {
            res += v;
            return;
        }

        sum(node.left, v);
        sum(node.right, v);
    }
}
