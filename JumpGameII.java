/**
Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Your goal is to reach the last index in the minimum number of jumps.

For example:
Given array A = [2,3,1,1,4]

The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)

Note:
You can assume that you can always reach the last index.



Answer: We should think this array as a tree with layers, and each layer represent the elements you can reach in the same
steps. Then each time when we reach the max distance can be reached in k steps, we update the level number and the max distance,
until we reach the end.

Link: https://leetcode.com/problems/jump-game-ii/discuss/18023/Single-loop-simple-java-solution
*/
class Solution {
    public int jump(int[] nums) {
        if (nums.length < 2) return 0;
        int max = 0; //currently max distance can be reached
        int level = 0;
        int maxLevelDistance = 0; //max distance can be reach in level steps
        for (int i = 0; i < nums.length; i++) {
            if (i - 1 == maxLevelDistance) { //when reach max distance, update
                level++;
                maxLevelDistance = max;
            }
            max = Math.max(max, i + nums[i]);
        }
        return level;
    }
}
