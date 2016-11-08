/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
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
    private ListNode curr;

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        int size = 0;
        ListNode p = head;
        curr = head;
        while (p != null) {
            p = p.next;
            size++;
        }

        return transfer(0, size - 1);
    }

    private TreeNode transfer(int s, int e) {
        if (s > e) return null;

        int m = (s + e) / 2;
        TreeNode l = transfer(s, m - 1);

        TreeNode c = new TreeNode(curr.val);
        curr = curr.next;

        TreeNode r = transfer(m + 1, e);
        c.left = l;
        c.right = r;

        return c;
    }
}
