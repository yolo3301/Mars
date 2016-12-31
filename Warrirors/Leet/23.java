/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        ListNode fake = new ListNode(0);
        ListNode last = fake;
        Queue<ListNode> heap = new PriorityQueue<>(lists.length, new Comparator<ListNode>() {
            public int compare(ListNode v1, ListNode v2) {
                return v1.val - v2.val;
            }
        });

        for (ListNode n : lists)
            if (n != null) heap.add(n);

        while (!heap.isEmpty()) {
            ListNode curr = heap.remove();
            last.next = curr;
            last = curr;

            if (curr.next != null) {
                heap.add(curr.next);
            }
        }

        return fake.next;
    }
}
