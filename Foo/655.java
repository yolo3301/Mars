/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<List<String>> printTree(TreeNode root) {
        int h = height(root);
        int w = width(root);
        List<List<String>> container = new ArrayList<>();

        for (int i = 0; i < h; i++) {
            List<String> curr = new ArrayList<>();
            for (int j = 0; j < w; j++) {
                curr.add("");
            }
            container.add(curr);
        }

        print(root, container, 0, 0, w-1);
        return container;
    }

    private void print(TreeNode node, List<List<String>> container, int level, int s , int e) {
        if (node == null) return;
        int m = s + (e - s) / 2;
        container.get(level).set(m, Integer.toString(node.val));
        print(node.left, container, level+1, s, m-1);
        print(node.right, container, level+1, m+1, e);
    }

    private int height(TreeNode node) {
        if (node == null) return 0;
        return Math.max(height(node.left), height(node.right)) + 1;
    }

    private int width(TreeNode node) {
        if (node == null) return 0;
        return Math.max(width(node.left), width(node.right)) * 2 + 1;
    }
}