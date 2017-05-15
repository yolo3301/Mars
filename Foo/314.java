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
    int min = Integer.MAX_VALUE;
    int max = Integer.MIN_VALUE;
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        Map<TreeNode, Integer> map = new HashMap<>();
        findDepth(root, 0, map);
        int size = max - min + 1;
        for (int i = 0; i < size; i++) res.add(new ArrayList<>());

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            TreeNode curr = q.remove();
            res.get(map.get(curr) - min).add(curr.val);
            if (curr.left != null) q.add(curr.left);
            if (curr.right != null) q.add(curr.right);
        }

        return res;
    }

    private void findDepth(TreeNode node, int level, Map<TreeNode, Integer> map) {
        if (node == null) return;
        min = Math.min(min, level);
        max = Math.max(max, level);
        map.put(node, level);
        findDepth(node.left, level-1, map);
        findDepth(node.right, level+1, map);
    }
}