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

        ListNode last = head;
        ListNode n = head.next;

        while (n != null) {
            while (n != null && n.val == last.val) {
                n = n.next;
            }
            last.next = n;
            last = n;

            if (last != null) {
                n = last.next;
            }
        }

        return head;
    }
}
