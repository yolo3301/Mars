/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return head;

        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}

public class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode p = null;
        ListNode q = head;

        while (q != null) {
            ListNode t = q.next;
            q.next = p;
            p = q;
            q = t;
        }

        return p;
    }
}
