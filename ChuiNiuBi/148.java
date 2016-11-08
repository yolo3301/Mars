/*
148. Sort List

Sort a linked list in O(n log n) time using constant space complexity.
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;
            
        ListNode mid = findMid(head);
        ListNode right = sortList(mid.next);
        mid.next = null;
        ListNode left = sortList(head);
        
        return merge(left, right);
    }
    
    private ListNode findMid(ListNode node) {
        ListNode slow = node, fast = node.next;
        while (slow != null && fast != null) {
            fast = fast.next;
            if (fast == null)   break;
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
    
    private ListNode merge(ListNode left, ListNode right) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while (left != null && right != null) {
            if (left.val < right.val) {
                tail.next = left;
                left = left.next;
            } else {
                tail.next = right;
                right = right.next;
            }
            tail = tail.next;
        }
        if (left != null) {
            tail.next = left;
        } else if (right != null) {
            tail.next = right;
        }
        return dummy.next;
    }
}