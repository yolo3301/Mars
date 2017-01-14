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
    public TreeNode deleteNode(TreeNode root, int key) {
        TreeNode toRm = find(root, key);
        if (toRm != null) {
            if (toRm == root && toRm.left == null && toRm.right == null)
                return null;
            else
                adjust(toRm, root);
        }

        return root;
    }

    private void adjust(TreeNode toRm, TreeNode root) {
        if (toRm.left == null && toRm.right == null) {
            deleteLeaf(root, toRm);
        } else if (toRm.left != null) {
            TreeNode p = toRm.left, last = toRm;
            while (p.right != null) {
                last = p;
                p = p.right;
            }

            toRm.val = p.val;
            if (last == toRm) {
                toRm.left = p.left;
            } else {
                last.right = p.left;
            }
        } else {
            TreeNode p = toRm.right, last = toRm;
            while (p.left != null) {
                last = p;
                p = p.left;
            }

            toRm.val = p.val;
            if (toRm == last) {
                toRm.right = p.right;
            } else {
                last.left = p.right;
            }
        }
    }

    private void deleteLeaf(TreeNode node, TreeNode target) {
        if (node.left == target) {
            node.left = null;
            return;
        } else if (node.right == target) {
            node.right = null;
            return;
        }

        if (target.val < node.val) {
            deleteLeaf(node.left, target);
        } else {
            deleteLeaf(node.right, target);
        }
    }

    private TreeNode find(TreeNode node, int key) {
        if (node == null) return null;
        if (node.val == key) return node;

        if (key < node.val) return find(node.left, key);
        else return find(node.right, key);
    }
}
