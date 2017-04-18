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
        TreeLinkNode curr = root;
        TreeLinkNode head = null, prev = null;

        while (curr != null) {
            if (curr.left != null) {
                if (head == null) {
                    head = curr.left;
                    prev = head;
                } else {
                    prev.next = curr.left;
                    prev = curr.left;
                }
            }

            if (curr.right != null) {
                if (head == null) {
                    head = curr.right;
                    prev = head;
                } else {
                    prev.next = curr.right;
                    prev = curr.right;
                }
            }

            if (curr.next != null) curr = curr.next;
            else {
                curr = head;
                head = null;
                prev = null;
            }
        }
    }
}