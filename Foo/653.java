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
    public boolean findTarget(TreeNode root, int k) {
        ls = new Stack<>();
        rs = new Stack<>();
        prepareLeft(root);
        prepareRight(root);
        TreeNode l = next();
        TreeNode r = reverseNext();

        while (l != r && l.val <= r.val) {
            if (l.val + r.val == k) return true;
            if (l.val + r.val < k) l = next();
            else r = reverseNext();
        }

        return false;
    }

    private Stack<TreeNode> ls, rs;

    private TreeNode next() {
        if (ls.empty()) return null;
        TreeNode res = ls.pop();
        if (res.right != null) {
            prepareLeft(res.right);
        }
        return res;
    }

    private void prepareLeft(TreeNode ln) {
        while (ln != null) {
            ls.push(ln);
            ln = ln.left;
        }
    }

    private TreeNode reverseNext() {
        if (rs.empty()) return null;
        TreeNode res = rs.pop();
        if (res.left != null) {
            prepareRight(res.left);
        }
        return res;
    }

    private void prepareRight(TreeNode rn) {
        while (rn != null) {
            rs.push(rn);
            rn = rn.right;
        }
    }
}