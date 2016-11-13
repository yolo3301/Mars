/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;
        ListNode p = head.next.next, q = head.next;
        while (p != null && p != q) {
            if (p.next == null) return null;
            p = p.next.next;
            q = q.next;
        }

        if (p == null) return null;

        p = head;
        while (p != q) {
            p = p.next;
            q = q.next;
        }

        return p;
    }
}
