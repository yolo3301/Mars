/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return null;
        ListNode fake = new ListNode(0);
        fake.next = head;
        ListNode p = head, q = fake;
        for (int i = 0; i < n; i++) {
            p = p.next;
        }

        while (p != null) {
            q = q.next;
            p = p.next;
        }

        q.next = q.next.next;

        return fake.next;
    }
}
