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
        int[] res = findMax(root);

        return Math.max(res[0], res[1]);
    }

    private int[] findMax(TreeNode node) {
        if (node == null) {
            return new int[] {0, 0};
        }

        int[] l = findMax(node.left);
        int[] r = findMax(node.right);

        int[] res = new int[2];
        res[0] = Math.max(l[0], l[1]) + Math.max(r[0], r[1]);
        res[1] = node.val + l[0] + r[0];

        return res;
    }
}

// tree? -- think about recursive
// sub strcuture/problem
