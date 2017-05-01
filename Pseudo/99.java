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
        TreeNode p = root, w1 = null, w2 = null, last = null;
        while (p != null) {
            if (p.left != null) {
                TreeNode q = p.left;
                while (q.right != null && q.right != p) {
                    q = q.right;
                }

                if (q.right == null) {
                    q.right = p;
                    p = p.left;
                } else {
                    // visit p
                    if (last != null && p.val < last.val) {
                        w2 = p;
                        if (w1 == null) w1 = last;
                    }
                    last = p;

                    q.right = null;
                    p = p.right;
                }
            } else {
                // visit p
                if (last != null && p.val < last.val) {
                    w2 = p;
                    if (w1 == null) w1 = last;
                }
                last = p;

                p = p.right;
            }
        }

        if (w1 != null) {
            int tmp = w1.val;
            w1.val = w2.val;
            w2.val = tmp;
        }
    }
}