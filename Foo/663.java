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
    Set<Integer> sums = new HashSet<>();
    TreeNode e;
    public boolean checkEqualTree(TreeNode root) {
        e = root;
        int t = sum(root);
        if (t % 2 != 0) return false;
        return sums.contains(t/2);
    }

    private int sum(TreeNode node) {
        if (node == null) return 0;
        int r = sum(node.left) + sum(node.right) + node.val;
        if (node != e)
            sums.add(r);
        return r;
    }
}