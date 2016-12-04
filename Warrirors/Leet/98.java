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
    private boolean res = true;

    public boolean isValidBST(TreeNode root) {
        minMax(root);
        return res;
    }

    private int[] minMax(TreeNode node) {
        if (node == null) return new int[0];

        int[] left = minMax(node.left);
        int[] right = minMax(node.right);

        if (!((left.length == 0 || left[1] < node.val) && (right.length == 0 || right[0] > node.val)))
            res = false;

        int[] curr = new int[2];
        curr[0] = node.val;
        if (left.length != 0) curr[0] = Math.min(curr[0], left[0]);
        if (right.length != 0) curr[0] = Math.min(curr[0], right[0]);
        curr[1] = node.val;
        if (left.length != 0) curr[1] = Math.max(curr[1], left[1]);
        if (right.length != 0) curr[1] = Math.max(curr[1], right[1]);

        return curr;
    }
}
