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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Stack<TreeNode> s = new Stack<>();
        TreeNode p = root;

        while (p != null) {
            while (p != null) {
                s.push(p);
                p = p.left;
            }

            while (!s.empty() && s.peek().right == null) {
                p = s.pop();
                res.add(p.val);
            }

            if (s.empty()) p = null;
            else {
                p = s.pop();
                res.add(p.val);
                p = p.right;
            }
        }

        return res;
    }
}