/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode n = swapPairs(head.next.next);
        ListNode nh = head.next;
        head.next.next = head;
        head.next = n;

        return nh;
    }
}
