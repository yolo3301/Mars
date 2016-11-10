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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Stack<TreeNode> s = new Stack<>();
        s.push(root);
        boolean fromRight = false;

        while (!s.empty()) {
            int size = s.size();
            Stack<TreeNode> tmp = new Stack<>();
            List<Integer> l = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode curr = s.pop();
                l.add(curr.val);
                if (fromRight) {
                    if (curr.right != null) tmp.push(curr.right);
                    if (curr.left != null) tmp.push(curr.left);
                } else {
                    if (curr.left != null) tmp.push(curr.left);
                    if (curr.right != null) tmp.push(curr.right);
                }
            }
            fromRight = !fromRight;
            res.add(l);
            s = tmp;
        }

        return res;
    }
}
