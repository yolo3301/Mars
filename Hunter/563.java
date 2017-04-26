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
    public int findTilt(TreeNode root) {
        return helper(root)[0];
    }

    private int[] helper(TreeNode node) {
        if (node == null) return new int[2];
        int[] l = helper(node.left);
        int[] r = helper(node.right);
        return new int[]{l[0]+r[0]+Math.abs(l[1]-r[1]), l[1]+r[1]+node.val};
    }
}