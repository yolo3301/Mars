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
    public int countUnivalSubtrees(TreeNode root) {
        helper(root);
        return res;
    }

    int res = 0;

    // int[] -- is uni-val, the uni-val
    private int[] helper(TreeNode node) {
        if (node == null) return new int[]{-1, 0};

        int[] l = helper(node.left);
        int[] r = helper(node.right);
        boolean uni = true;

        if (l[0] == 1) {
            uni &= (l[1] == node.val);
        } else if (l[0] == 2) {
            uni = false;
        }

        if (r[0] == 1) {
            uni &= (r[1] == node.val);
        } else if (r[0] == 2) {
            uni = false;
        }

        if (uni) res++;

        return new int[]{uni ? 1 : 2, node.val};
    }
}