/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        ListNode fake = new ListNode(0);
        fake.next = head;
        ListNode p = fake;

        while (p.next != null) {
            int cand = p.next.val;
            ListNode q = p.next.next;
            while (q != null && q.val == cand) {
                q = q.next;
            }

            if (q == p.next.next) {
                p = p.next;
            } else {
                p.next = q;
            }
        }

        return fake.next;
    }
}
