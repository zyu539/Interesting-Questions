/**
The thief has found himself a new place for his thievery again. There is only one entrance to this area, called the "root." Besides the root, each house has one and only one parent house. After a tour, the smart thief realized that "all houses in this place forms a binary tree". It will automatically contact the police if two directly-linked houses were broken into on the same night.

Determine the maximum amount of money the thief can rob tonight without alerting the police.

Example 1:
     3
    / \
   2   3
    \   \ 
     3   1
Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.
Example 2:
     3
    / \
   4   5
  / \   \ 
 1   3   1
Maximum amount of money the thief can rob = 4 + 5 = 9.
Link: https://leetcode.com/problems/house-robber-iii/description/



Answer: Use DFS to go through the tree and use rescursive method to get the max value without
robbing the root and robbing the root.

Idea comes from: https://leetcode.com/problems/house-robber-iii/discuss/79363/Easy-understanding-solution-with-dfs
Great solution
*/
class HouseRobber {
    public int rob(TreeNode root) {
        int[] res = dfs(root);
        return Math.max(res[0], res[1]);
    }
    
    private int[] dfs(TreeNode root) {
        if (root == null) return new int[2];
        if (root.left == null && root.right == null) return new int[]{root.val, 0};
        int[] res = new int[2];
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
        res[0] = left[1] + right[1] + root.val;
        res[1] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        return res;
    }
}
