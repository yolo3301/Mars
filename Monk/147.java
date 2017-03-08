/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode insertionSortList(ListNode head) {
        if (head == null) return null;

        ListNode f = new ListNode(0);
        ListNode p = head;

        while (p != null) {
            ListNode q = f;
            while (q.next != null && q.next.val < p.val) {
                q = q.next;
            }

            ListNode tmp = p.next;
            p.next = q.next;
            q.next = p;
            p = tmp;
        }

        return f.next;
    }
}