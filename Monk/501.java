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
    private int count = 0, maxCount = 0, size = 0, index = 0;
    private int[] res;
    private boolean flag = true;
    public int[] findMode(TreeNode root) {
        if (root == null) return new int[0];
        traverse(root);
        res = new int[size];
        count = 0;
        flag = false;
        traverse(root);

        return res;
    }

    private void traverse(TreeNode node) {
        if (node == null) return;
        traverse(node.left);
        if (last != null && last.val == node.val) count++;
        else count = 1;

        if (flag) {
            if (count > maxCount) {
                maxCount = count;
                size = 1;
            } else if (count == maxCount) {
                size++;
            }
        } else {
            if (count == maxCount) {
                res[index++] = node.val;
            }
        }

        last = node;
        traverse(node.right);
    }
}