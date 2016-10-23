/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        if (root == null) return;
        LinkedList<TreeLinkNode> q = new LinkedList<>();
        q.add(root);

        while (q.peek() != null) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeLinkNode curr = q.remove();
                if (i == 0) {
                    curr.next = null;
                }
                if (q.peek() != null) {
                    q.peek().next = curr;
                }

                if (curr.right != null) q.add(curr.right);
                if (curr.left != null) q.add(curr.left);
            }
        }
    }
}
