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
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        helper(root);
        return new ArrayList<>(res);
    }

    Set<TreeNode> res = new HashSet<>();
    Map<String, TreeNode> map = new HashMap<>();

    private String helper(TreeNode node) {
        if (node == null) return "#";

        String left = helper(node.left);
        String right = helper(node.right);
        String curr = node.val + left + right;
        if (map.containsKey(curr)) {
            res.add(map.get(curr));
        } else {
            map.put(curr, node);
        }

        return curr;
    }
}