/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public int numComponents(ListNode head, int[] G) {
        Set<Integer> g = new HashSet<>();
        for (int i : G) g.add(i);

        int cnt = 0;
        ListNode p = head;
        boolean f = false;
        while (p != null) {
            if (g.contains(p.val) && !f) {
                cnt++;
                f = true;
            } else if (!g.contains(p.val)) {
                f = false;
            }

            p = p.next;
        }

        return cnt;
    }
}