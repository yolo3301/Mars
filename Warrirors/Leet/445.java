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

        ListNode h1 = reverse(l1);
        ListNode h2 = reverse(l2);

        int c = 0;
        ListNode h3 = new ListNode(0);
        ListNode last = h3;
        while (h1 != null && h2 != null) {
            int curr = h1.val + h2.val + c;
            ListNode n = new ListNode(curr % 10);
            last.next = n;
            last = n;
            c = curr / 10;
            h1 = h1.next;
            h2 = h2.next;
        }

        while (h1 != null) {
            int curr = h1.val + c;
            ListNode n = new ListNode(curr % 10);
            last.next = n;
            last = n;
            c = curr / 10;
            h1 = h1.next;
        }
        while (h2 != null) {
            int curr = h2.val + c;
            ListNode n = new ListNode(curr % 10);
            last.next = n;
            last = n;
            c = curr / 10;
            h2 = h2.next;
        }

        if (c != 0) {
            ListNode n = new ListNode(c);
            last.next = n;
        }

        h3 = h3.next;
        return reverse(h3);
    }

    private ListNode reverse(ListNode node) {
        if (node == null) return null;
        if (node.next == null) return node;

        ListNode h = reverse(node.next);
        node.next.next = node;
        node.next = null;

        return h;
    }
}
