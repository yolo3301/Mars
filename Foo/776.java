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
    public TreeNode[] splitBST(TreeNode root, int V) {
        if (root == null) return new TreeNode[2];

        TreeNode[] ret = new TreeNode[2];

        if (root.val <= V) {
            ret[0] = root;
            TreeNode[] right = splitBST(root.right, V);
            ret[0].right = right[0];
            ret[1] = right[1];
            return ret;
        } else {
            ret[1] = root;
            TreeNode[] left = splitBST(root.left, V);
            ret[1].left = left[1];
            ret[0] = left[0];
            return ret;
        }
    }
}