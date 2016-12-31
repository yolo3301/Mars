/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;

        ListNode p = headA;
        ListNode q = headB;
        int l1 = 0, l2 = 0;

        while (p != null) {
            l1++;
            p = p.next;
        }

        while (q != null) {
            l2++;
            q = q.next;
        }

        if (l1 > l2) {
            p = headA;
            q = headB;
        } else {
            p = headB;
            q = headA;
        }

        int d = Math.abs(l1 - l2);

        while (d > 0) {
            d--;
            p = p.next;
        }

        while (p != null && p != q) {
            p = p.next;
            q = q.next;
        }

        return p;
    }
}
