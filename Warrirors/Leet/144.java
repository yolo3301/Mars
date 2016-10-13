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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Stack<TreeNode> s = new Stack<>();
        s.push(root);

        while (!s.empty()) {
            TreeNode t = s.pop();
            res.add(t.val);
            if (t.right != null) s.push(t.right);
            if (t.left != null) s.push(t.left);
        }

        return res;
    }
}
