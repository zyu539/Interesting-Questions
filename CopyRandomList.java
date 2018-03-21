/**
 * A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.
 * Return a deep copy of the list.
 *
 *
 *
 *
 *
 *
 * Answer: First link the original list with copy list in zig-zag pattern, link cop.random to origin.random.
 * Then link the random link of copy to its own node. Finally restore the original list and extract copy list.
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) return null;
        RandomListNode p = head;
        RandomListNode next = null;
        while (head != null) {
            next = head.next;
            RandomListNode rln = new RandomListNode(head.label);
            rln.next = head.next;
            head.next = rln;
            rln.random = head.random;
            head = next;
        }
        
        head = p.next;
        while (head != null) {
            if (head.random == null) {
                head.random = null;
            } else {
                head.random = head.random.next;
            }
            head = head.next == null ? null : head.next.next;
        }
        
        head = p.next;
        RandomListNode oh = p;
        RandomListNode ch = p.next;
        while (oh != null && ch != null) {
            oh.next = ch.next;
            ch.next = ch.next == null ? null : ch.next.next;
            oh = oh.next;
            ch = ch.next;
        }
        return head;
    }
}
