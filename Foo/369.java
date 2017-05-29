/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode plusOne(ListNode head) {
        ListNode h = reverse(head);
        ListNode p = h, last = null;
        int c = 1;

        while (c != 0 && p != null) {
            p.val += c;
            c = p.val / 10;
            p.val %= 10;
            if (p.next == null) last = p;
            p = p.next;
        }

        if (c != 0) {
            ListNode t = new ListNode(c);
            last.next = t;
        }

        return reverse(h);
    }

    private ListNode reverse(ListNode node) {
        if (node.next == null) {
            return node;
        }

        ListNode newHead = reverse(node.next);
        node.next.next = node;
        node.next = null;

        return newHead;
    }
}