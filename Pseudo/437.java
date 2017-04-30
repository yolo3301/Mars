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
    public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        Map<Integer, Integer> sums = new HashMap<>();
        sums.put(0, 1);
        helper(root, sum, 0, sums);

        return res;
    }

    int res = 0;

    private void helper(TreeNode node, int sum, int acc, Map<Integer, Integer> sums) {
        if (node == null) return;

        acc += node.val;
        res += sums.getOrDefault(acc - sum, 0);
        int cnt = sums.getOrDefault(acc, 0);
        sums.put(acc, cnt + 1);
        helper(node.left, sum, acc, sums);
        helper(node.right, sum, acc, sums);
        sums.put(acc, cnt);
    }
}