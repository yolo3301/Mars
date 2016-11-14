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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> inorderIndex = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderIndex.put(inorder[i], i);
        }
        return build(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1, inorderIndex);
    }

    private TreeNode build(int[] inorder, int[] postorder, int s1, int e1, int s2, int e2, Map<Integer, Integer> inorderIndex) {
        if (s1 > e1 || s2 > e2) return null;
        TreeNode curr = new TreeNode(postorder[e2]);
        int index = inorderIndex.get(curr.val);
        int leftSize = index - s1;
        int rightSize = e1 - index;
        curr.left = build(inorder, postorder, s1, index - 1, s2, s2 + leftSize - 1, inorderIndex);
        curr.right = build(inorder, postorder, index + 1, e1, e2 - rightSize, e2 - 1, inorderIndex);
        return curr;
    }
}
