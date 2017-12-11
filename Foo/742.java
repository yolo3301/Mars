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
    public int findClosestLeaf(TreeNode root, int k) {
        helper(root, k);
        return minDistNodeVal;
    }

    int minDist = Integer.MAX_VALUE;
    int minDistNodeVal = 0;

    private int[] helper(TreeNode node, int k) {
        if (node.left == null && node.right == null) {
            int match = (node.val == k) ? 1 : 0;
            if (match == 1) {
                minDist = 0;
                minDistNodeVal = k;
            }
            return new int[]{match, 0, 0, node.val};
        }

        int[] ret = new int[4];
        ret[0] = (node.val == k) ? 1 : 0;
        ret[1] = Integer.MAX_VALUE;

        if (node.left != null) {
            int[] l = helper(node.left, k);
            if (l[0] == 1) {
                ret[0] = 1;
                ret[2] = l[2]+1;
            }
            if (l[1]+1 < ret[1]) {
                ret[1] = l[1]+1;
                ret[3] = l[3];
            }
        }

        if (node.right != null) {
            int[] r = helper(node.right, k);
            if (r[0] == 1) {
                ret[0] = 1;
                ret[2] = r[2]+1;
            }
            if (r[1]+1 < ret[1]) {
                ret[1] = r[1]+1;
                ret[3] = r[3];
            }
        }

        if (ret[0] == 1) {
            if (ret[1] + ret[2] < minDist) {
                minDist = ret[1] + ret[2];
                minDistNodeVal = ret[3];
            }
        }

        return ret;
    }
}