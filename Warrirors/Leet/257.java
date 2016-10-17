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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        traverse(root, "", res);

        return res;
    }

    private void traverse(TreeNode n, String buffer, List<String> result) {
        if (n == null) return;
        if (buffer.equals("")) buffer += Integer.toString(n.val);
        else buffer += "->" + Integer.toString(n.val);

        if (n.left == null && n.right == null) {
            result.add(buffer);
            return;
        }

        traverse(n.left, buffer, result);
        traverse(n.right, buffer, result);
    }
}
