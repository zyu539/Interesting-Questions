/**
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 */


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
        ListNode head = new ListNode(0);
        ListNode tmp = head;
        PriorityQueue<ListNode> pq = new PriorityQueue<>(((a, b)-> a.val - b.val));
        for (ListNode ln : lists) {
            if (ln != null) pq.add(ln);
        }
        while (pq.size() != 0) {
            ListNode n = pq.remove();
            tmp.next = n;
            tmp = tmp.next;
            if (n.next != null) pq.add(n.next);
        }
        return head.next;
    }
}
