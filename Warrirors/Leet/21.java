/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode fh = new ListNode(0);
        ListNode w1 = l1, w2 = l2, w = fh;

        while (w1 != null && w2 != null) {
            if (w1.val <= w2.val) {
                w.next = w1;
                w = w.next;
                w1 = w1.next;
            } else {
                w.next = w2;
                w = w.next;
                w2 = w2.next;
            }
        }

        if (w1 == null) {
            w.next = w2;
        }

        if (w2 == null) {
            w.next = w1;
        }

        return fh.next;
    }
}
