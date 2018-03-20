/**
Note:

You may only use constant extra space.
For example,
Given the following binary tree,
         1
       /  \
      2    3
     / \    \
    4   5    7
After calling your function, the tree should look like:
         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \    \
    4-> 5 -> 7 -> NULL
    
Link: https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/description/




Answer: We use 3 pointers to store the state of out current work, curr, prev, and head. The thing I want to show here is
we can make use of previous level nodes which we should have already populated (the next pointer has already been set).
*/
public class Solution {
    public void connect(TreeLinkNode root) {
        TreeLinkNode curr = null; //current element in upper level
        TreeLinkNode prev = null; //previous element of lower level
        TreeLinkNode head = root; //first element of lower level
        while (head != null) {
            curr = head;
            prev = null;
            head = null;
            while (curr != null) {
                if (curr.left != null) {
                    if (prev != null) {
                        prev.next = curr.left;
                    } else {
                        head = curr.left;
                    }
                    prev = curr.left;
                }
                
                if (curr.right != null) {
                    if (prev != null) {
                        prev.next = curr.right;
                    } else {
                        head = curr.right;
                    }
                    prev = curr.right;
                }
                curr = curr.next;
            }
        }
    }
}

class TreeLinkNode {
    int val;
    TreeLinkNode left, right, next;
    TreeLinkNode(int x) { val = x; }
}
