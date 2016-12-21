// Probably learn mirror traversal.
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
    private TreeNode last = null;
    private TreeNode first = null;
    private TreeNode second = null;

    public void recoverTree(TreeNode root) {
        traverse(root);
        if (first != null && second != null) {
            int tmp = first.val;
            first.val = second.val;
            second.val = tmp;
        }
    }

    private void traverse(TreeNode node) {
        if (node == null) return;
        traverse(node.left);

        if (last != null && node.val < last.val) {
            if (first == null) {
                first = last;
                second = node;
            } else {
                second = node;
            }
        }

        last = node;

        traverse(node.right);
    }
}
