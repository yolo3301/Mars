/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return head;

        ListNode f = new ListNode(0);
        f.next = head;

        ListNode p = f, q = f;
        while (p != null && p.next != null) {
            p = p.next.next;
            q = q.next;
        }

        p = q.next;
        q.next = null;

        ListNode left = sortList(head);
        ListNode right = sortList(p);

        p = left;
        q = right;
        f.next = null;
        ListNode last = f;

        while (p != null && q != null) {
            if (p.val <= q.val) {
                last.next = p;
                last = p;
                p = p.next;
            } else {
                last.next = q;
                last = q;
                q = q.next;
            }
        }

        while (p != null) {
            last.next = p;
            last = p;
            p = p.next;
        }

        while (q != null) {
            last.next = q;
            last = q;
            q = q.next;
        }

        return f.next;
    }
}
