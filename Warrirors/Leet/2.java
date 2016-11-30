/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode f = new ListNode(0);
        ListNode last = f;
        ListNode p = l1, q = l2;
        int carry = 0;

        while (p != null && q != null) {
            int v = (p.val + q.val + carry) % 10;
            carry = (p.val + q.val + carry) / 10;
            ListNode curr = new ListNode(v);
            last.next = curr;
            last = curr;
            p = p.next;
            q = q.next;
        }

        while (p != null) {
            int v = (p.val + carry) % 10;
            carry = (p.val + carry) / 10;
            ListNode curr = new ListNode(v);
            last.next = curr;
            last = curr;
            p = p.next;
        }

        while (q != null) {
            int v = (q.val + carry) % 10;
            carry = (q.val + carry) / 10;
            ListNode curr = new ListNode(v);
            last.next = curr;
            last = curr;
            q = q.next;
        }

        if (carry > 0) {
            ListNode curr = new ListNode(carry);
            last.next = curr;
            last = curr;
        }

        return f.next;
    }
}
