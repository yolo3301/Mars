/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        ListNode f = new ListNode(0);
        f.next = head;
        ListNode p = f, q = f;
        while (p != null && p.next != null) {
            p = p.next.next;
            q = q.next;
        }

        p = reverse(q.next);
        q.next = null;
        q = head;
        ListNode l = f;
        while (q != null && p != null) {
            ListNode tmp = q.next;
            l.next = q;
            l.next.next = p;
            l = p;
            q = tmp;
            p = p.next;
        }

        if (q != null) l.next = q;
    }

    private ListNode reverse(ListNode node) {
        if (node.next == null) return node;

        ListNode head = reverse(node.next);
        node.next.next = node;
        node.next = null;

        return head;
    }
}
