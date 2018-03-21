/**
Given a binary tree, find the maximum path sum.

For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The path must contain at least one node and does not need to go through the root.

For example:
Given the below binary tree,

       1
      / \
     2   3
Return 6.

*/
class Solution {
    int maxValue = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if (root == null) return 0; 
        maxPathDown(root);
        return maxValue;
    }
    
    private int maxPathDown(TreeNode root) {
        if (root == null) return 0;
        int left = Math.max(maxPathDown(root.left), 0);
        int right = Math.max(maxPathDown(root.right), 0);
        maxValue = Math.max(maxValue, left + right + root.val);
        return Math.max(left, right) + root.val;
    }
}
