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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        find(root, sum, new ArrayList<Integer>(), 0, res);
        return res;
    }

    private void find(TreeNode node, int sum, List<Integer> buffer, int curr, List<List<Integer>> res) {
        if (node == null) return;

        buffer.add(node.val);
        curr += node.val;

        if (node.left == null && node.right == null) {
            if (curr == sum) {
                res.add(new ArrayList<Integer>(buffer));
            }

            buffer.remove(buffer.size() - 1);
            return;
        }

        find(node.left, sum, buffer, curr, res);
        find(node.right, sum, buffer, curr, res);

        buffer.remove(buffer.size() - 1);
    }
}
