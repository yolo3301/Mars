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
    public int longestConsecutive(TreeNode root) {
        helper(root);
        return max;
    }

    int max = 0;

    private int[] helper(TreeNode node) {
        if (node == null) return new int[2];

        int[] l = helper(node.left);
        int[] r = helper(node.right);

        int[] res = new int[2];
        if (node.left != null && node.val+1 == node.left.val) {
            res[0] = l[0];
        }
        if (node.right != null && node.val+1 == node.right.val) {
            res[0] = Math.max(res[0], r[0]);
        }
        res[0]++;
        if (node.left != null && node.val-1 == node.left.val) {
            res[1] = l[1];
        }
        if (node.right != null && node.val-1 == node.right.val) {
            res[1] = Math.max(res[1], r[1]);
        }
        res[1]++;

        max = Math.max(max, res[0]);
        max = Math.max(max, res[1]);
        max = Math.max(max, res[0] + res[1] - 1);
        
        // System.out.println(node.val + " " + res[0] + " " + res[1]);
        
        return res;
    }
}