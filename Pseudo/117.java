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
        TreeLinkNode p = root;
        TreeLinkNode head = null, last = null;
        while (p != null) {
            if (p.left != null) {
                if (last == null) {
                    head = p.left;
                    last = p.left;
                } else {
                    last.next = p.left;
                    last = p.left;
                }
            }

            if (p.right != null) {
                if (last == null) {
                    head = p.right;
                    last = p.right;
                } else {
                    last.next = p.right;
                    last = p.right;
                }
            }

            if (p.next != null) {
                p = p.next;
            } else {
                p = head;
                head = null;
                last = null;
            }
        }
    }
}