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
    List<Integer> min = new ArrayList<>();
    int res = 0;

    public int widthOfBinaryTree(TreeNode root) {
        helper(root, 0, 0);
        return res;
    }

    private void helper(TreeNode node, int level, int val) {
        if (node == null) return;
        if (level < min.size()) {
            res = Math.max(res, val - min.get(level) + 1);
        } else {
            min.add(val);
            res = Math.max(res, 1);
        }

        helper(node.left, level+1, 2*val);
        helper(node.right, level+1, 2*val+1);
    }
}