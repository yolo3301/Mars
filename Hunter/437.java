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
    int res = 0;
    public int pathSum(TreeNode root, int sum) {
        allSums(root, sum);
        return res;
    }

    private Map<Long, Integer> allSums(TreeNode node, int target) {
        if (node == null) return new HashMap<>();

        Map<Long, Integer> l = allSums(node.left, target);
        Map<Long, Integer> r = allSums(node.right, target);

        Map<Long, Integer> curr = new HashMap<>();
        curr.put((long)node.val, 1);
        for (long k : l.keySet()) {
            curr.put(k + node.val, curr.getOrDefault(k+node.val, 0)+l.get(k));
        }
        for (long k : r.keySet()) {
            curr.put(k + node.val, curr.getOrDefault(k+node.val, 0)+r.get(k));
        }
        
        res += curr.getOrDefault((long)target, 0);

        return curr;
    }
}