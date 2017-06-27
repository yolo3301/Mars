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
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        int d = depth(root);
        for (int i = 0; i < d; i++) {
            res.add(new ArrayList<>());
        }

        add(root, res);
        return res;
    }

    private int add(TreeNode node, List<List<Integer>> res) {
        if (node == null) return -1;
        int curr = Math.max(add(node.left, res), add(node.right, res)) + 1;
        res.get(curr).add(node.val);
        return curr;
    }

    private int depth(TreeNode node) {
        if (node == null) return 0;
        return Math.max(depth(node.left), depth(node.right)) + 1;
    }
}