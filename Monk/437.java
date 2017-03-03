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
        HashMap<Integer, Integer> cnt = new HashMap<>();
        cnt.put(0, 1);
        return helper(root, 0, sum, cnt);
    }

    private int helper(TreeNode node, int currSum, int target, HashMap<Integer, Integer> cnt) {
        if (node == null) return 0;

        currSum += node.val;
        int res = cnt.getOrDefault(currSum - target, 0);
        cnt.put(currSum, cnt.getOrDefault(currSum, 0) + 1);

        res += helper(node.left, currSum, target, cnt) + helper(node.right, currSum, target, cnt);
        cnt.put(currSum, cnt.get(currSum) - 1);

        return res;
    }
}