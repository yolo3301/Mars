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
    public int largestBSTSubtree(TreeNode root) {
        if (root == null) return 0;
        helper(root);
        return res;
    }

    int res = 0;

    // # of nodes, is BST, min, max
    private int[] helper(TreeNode node) {
        int min = node.val, max = node.val, cnt = 1;
        boolean isBST = true;
        if (node.left != null) {
            int[] l = helper(node.left);
            if (l[3] >= node.val || l[1] == 0) isBST = false;
            cnt += l[0];
            min = l[2];
        }

        if (node.right != null) {
            int[] r = helper(node.right);
            if (r[2] <= node.val || r[1] == 0) isBST = false;
            cnt += r[0];
            max = r[3];
        }

        if (isBST) {
            res = Math.max(res, cnt);
        }

        return new int[]{cnt, isBST ? 1 : 0, min, max};
    }
}