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
        ListNode fake = new ListNode(0);
        ListNode p = head;
        while (p != null) {
            ListNode tmp = p.next;
            ListNode q = fake;
            while (q.next != null && p.val > q.next.val) {
                q = q.next;
            }
            p.next = q.next;
            q.next = p;

            p = tmp;
        }

        return fake.next;
    }
}
