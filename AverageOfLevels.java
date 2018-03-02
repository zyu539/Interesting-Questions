/**
Question: Given a non-empty binary tree, return the average value of the nodes on each level in the form of an array.
Example 1:
Input:
    3
   / \
  9  20
    /  \
   15   7
Output: [3, 14.5, 11]
Explanation:
The average value of nodes on level 0 is 3,  on level 1 is 14.5, and on level 2 is 11. Hence return [3, 14.5, 11].




Answer: this is a quite simple question. just remind me of a new version of bfs: each time empty all elements in the queue
while add all children of those elements to the queue. In this way, we dont need to record the current level of the tree
in some cases.
*/
class AverageOfLevels {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(queue.peek() != null) {
            int n = queue.size();
            double sum = 0.0;
            for (int i = 0; i < n; i++) {
                TreeNode tn = queue.poll();
                sum += tn.val;
                if (tn.left != null) queue.add(tn.left);
                if (tn.right != null) queue.add(tn.right);
            }
            res.add(sum / n);
        }
        return res;
    }
}
