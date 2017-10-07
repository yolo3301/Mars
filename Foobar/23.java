/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        
        PriorityQueue<ListNode> queue = new PriorityQueue<>((a, b) -> {
            return a.val - b.val;
        });

        for (ListNode h : lists) {
            if (h != null)
                queue.add(h);
        }

        ListNode fake = new ListNode(0);
        ListNode last = fake;

        while (!queue.isEmpty()) {
            ListNode e = queue.remove();
            last.next = e;
            if (e.next != null)
                queue.add(e.next);
            last = e;
        }

        return fake.next;
    }
}

