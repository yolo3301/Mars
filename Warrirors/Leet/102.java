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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (q.peek() != null) {
            Queue<TreeNode> q2 = new LinkedList<>();
            List<Integer> l = new ArrayList<>();
            while (q.peek() != null) {
                TreeNode t = q.remove();
                l.add(t.val);
                if (t.left != null) q2.add(t.left);
                if (t.right != null) q2.add(t.right);
            }

            q = q2;
            res.add(l);
        }

        return res;
    }
}
