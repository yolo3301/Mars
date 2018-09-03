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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> l1 = new ArrayList<>();
        leaf(root1, l1);
        return check(root2, l1);
    }

    int idx = 0;
    private boolean check(TreeNode node, List<Integer> l) {
        if (node.left == null && node.right == null) {
            if (idx < l.size() && node.val == l.get(idx++)) {
                return true;
            } else {
                return false;
            }
        }

        boolean ret = true;

        if (node.left != null)
            ret &= check(node.left, l);
        if (node.right != null)
            ret &= check(node.right, l);

        return ret;
    }

    private void leaf(TreeNode node, List<Integer> l) {
        if (node.left == null && node.right == null) {
            l.add(node.val);
            return;
        }

        if (node.left != null)
            leaf(node.left, l);
        if (node.right != null)
            leaf(node.right, l);
    }
}