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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            Queue<TreeNode> next = new LinkedList<>();
            while (!q.isEmpty()) {
                TreeNode n = q.remove();
                level.add(n.val);
                if (n.left != null) next.add(n.left);
                if (n.right != null) next.add(n.right);
            }
            res.add(level);
            q = next;
        }

        Collections.reverse(res);

        return res;
    }
}
