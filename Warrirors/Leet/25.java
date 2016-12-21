/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) return null;
        ListNode p = head;
        int c = 1;
        while (c < k && p.next != null) {
            p = p.next;
            c++;
        }

        if (p.next == null && c < k) {
            return head;
        }

        ListNode tail = head;
        ListNode nextHead = p.next;
        p.next = null;
        ListNode newHead = reverse(head);
        tail.next = reverseKGroup(nextHead, k);

        return newHead;
    }

    private ListNode reverse(ListNode node) {
        if (node == null) return null;
        if (node.next == null) return node;

        ListNode newHead = reverse(node.next);
        node.next.next = node;
        node.next = null;

        return newHead;
    }
}
