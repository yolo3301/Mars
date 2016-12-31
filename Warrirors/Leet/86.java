/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode partition(ListNode head, int x) {
        if (head == null) return null;
        ListNode less = new ListNode(0);
        ListNode more = new ListNode(0);
        ListNode p = head, q1 = less, q2 = more;
        while (p != null) {
            ListNode tmp = p.next;
            if (p.val < x) {
                p.next = null;
                q1.next = p;
                q1 = p;
            } else {
                p.next = null;
                q2.next = p;
                q2 = p;
            }
            p = tmp;
        }
        q1.next = more.next;

        return less.next;
    }
}
