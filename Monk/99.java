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
    public void recoverTree(TreeNode root) {
        TreeNode p = root, prev = null, first = null, second = null;

        while (p != null) {
            if (p.left != null) {
                TreeNode tmp = p.left;
                while (tmp.right != null && tmp.right != p) {
                    tmp = tmp.right;
                }

                if (tmp.right != null) {
                    // visit p
                    if (prev != null && prev.val > p.val) {
                        if (first == null) {
                            first = prev;
                            second = p;
                        }
                        else second = p;
                    }
                    prev = p;

                    tmp.right = null;
                    p = p.right;
                } else {
                    tmp.right = p;
                    p = p.left;
                }
            } else {
                // visit p
                if (prev != null && prev.val > p.val) {
                    if (first == null) {
                        first = prev;
                        second = p;
                    }
                    else second = p;
                }
                prev = p;
                p = p.right;
            }
        }

        if (first != null) {
            int tmp = first.val;
            first.val = second.val;
            second.val = tmp;
        }
    }
}