/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return null;

        int len = 0;
        ListNode p = head, q = head;
        while (p != null) {
            len++;
            p = p.next;
        }

        k = k % len;
        if (k == 0) return head;

        p = head;
        for (int i = 0; i < k; i++) {
            p = p.next;
        }

        while (p.next != null) {
            p = p.next;
            q = q.next;
        }

        ListNode nh = q.next;
        q.next = null;
        p.next = head;

        return nh;
    }
}
