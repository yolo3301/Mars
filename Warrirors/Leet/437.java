//  not sure if the best solution

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
    private int res = 0;
    public int pathSum(TreeNode root, int sum) {
        find(root, sum, new ArrayList<Integer>());
        return res;
    }

    private void find(TreeNode node, int sum, List<Integer> buffer) {
        if (node == null) return;
        if (node.val == sum) res++;
        for (int i = 0; i < buffer.size(); i++) {
            if (buffer.get(i) + node.val == sum) res++;
            buffer.set(i, buffer.get(i) + node.val);
        }
        List<Integer> next = new ArrayList<>(buffer);
        next.add(node.val);
        find(node.left, sum, new ArrayList<Integer>(next));
        find(node.right, sum, new ArrayList<Integer>(next));
    }
}
