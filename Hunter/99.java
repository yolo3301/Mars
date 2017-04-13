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
        if (root == null) return;
        TreeNode v1 = null, v2 = null;
        TreeNode p = root, last = null;
        while (p != null) {
            if (p.left != null) {
                TreeNode tmp = p.left;
                while (tmp.right != null && tmp.right != p) {
                    tmp = tmp.right;
                }

                if (tmp.right != null) {
                    // visit p
                    if (last != null && p.val < last.val) {
                        v2 = p;
                        if (v1 == null) v1 = last;
                    }
                    last = p;

                    tmp.right = null;
                    p = p.right;
                } else {
                    tmp.right = p;
                    p = p.left;
                }
            } else {
                // visit p
                if (last != null && p.val < last.val) {
                    v2 = p;
                    if (v1 == null) v1 = last;
                }
                last = p;
                
                p = p.right;
            }
        }
        
        if (v1 == null) return;

        int t = v1.val;
        v1.val = v2.val;
        v2.val = t;
    }
}