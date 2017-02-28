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
    public int rob(TreeNode root) {
        int[] res = rob2(root);
        return Math.max(res[0], res[1]);
    }

    public int[] rob2(TreeNode node) {
        if (node == null) return new int[] {0, 0};
        
        int[] l = rob2(node.left);
        int[] r = rob2(node.right);

        return new int[] {
            l[1] + r[1] + node.val,
            Math.max(l[0], l[1]) + Math.max(r[0], r[1])
        };
    }
}