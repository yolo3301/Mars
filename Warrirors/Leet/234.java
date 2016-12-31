/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;

        ListNode p = head, q = head;

        while (q.next != null && q.next.next != null) {
            p = p.next;
            q = q.next.next;
        }

        ListNode last = null;
        q = p.next;
        p.next = null;

        while (q != null) {
            ListNode tmp = q.next;
            q.next = last;
            last = q;
            q = tmp;
        }

        q = last;
        ListNode o = head;

        while (o != null && q != null) {
            if (o.val != q.val) return false;
        }

        return true;
    }
}
