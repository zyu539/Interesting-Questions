/**
Given a binary tree, flatten it to a linked list in-place.

For example,
Given

         1
        / \
       2   5
      / \   \
     3   4   6
The flattened tree should look like:
   1
    \
     2
      \
       3
        \
         4
          \
           5
            \
             6
Hints:
If you notice carefully in the flattened tree, each node's right child points to the next node of a pre-order traversal.



Answer: Use a helper function to flatten the subtree of the root and set node "pre" to the root of the subtree.
We start from right hand side because we don't want to override unprocessed nodes.
*/
class Solution {
    public void flatten(TreeNode root) {
        flatten(root, null);
    }
    
    public TreeNode flatten(TreeNode root, TreeNode pre) {
        if (root == null) return pre;
        pre = flatten(root.right, pre);
        pre = flatten(root.left, pre);
        root.left = null;
        root.right = pre;
        pre = root;
        return pre;
    }
}
