/**
Given an array of scores that are non-negative integers.
Player 1 picks one of the numbers from either end of the array followed by the player 2 and then player 1 and so on.
Each time a player picks a number, that number will not be available for the next player. 
This continues until all the scores have been chosen. The player with the maximum score wins.

Given an array of scores, predict whether player 1 is the winner. You can assume each player plays to maximize his score.

Example 1:
Input: [1, 5, 2]
Output: False
Explanation: Initially, player 1 can choose between 1 and 2. 
If he chooses 2 (or 1), then player 2 can choose from 1 (or 2) and 5. If player 2 chooses 5, then player 1 will be left with 1 (or 2). 
So, final score of player 1 is 1 + 2 = 3, and player 2 is 5. 
Hence, player 1 will never be the winner and you need to return False.

Example 2:
Input: [1, 5, 233, 7]
Output: True
Explanation: Player 1 first chooses 1. Then player 2 have to choose between 5 and 7. No matter which number player 2 choose, player 1 can choose 233.
Finally, player 1 has more score (234) than player 2 (12), so you need to return True representing player1 can win.
Note:
1 <= length of the array <= 20.
Any scores in the given array are non-negative integers and will not exceed 10,000,000.
If the scores of both players are equal, then player 1 is still the winner.





Answer: Use recursive function(helper) to caluculate the difference between the choose number and the current optimized
choose result without considering that number.
Helper function simulate this process. In each round:
if e==s, there is no choice but have to select nums[s]
otherwise, this current player has 2 options:
–> nums[s]-helper(nums,s+1,e): this player select the front item, leaving the other player a choice from s+1 to e
–> nums[e]-helper(nums,s,e-1): this player select the tail item, leaving the other player a choice from s to e-1
Then take the max of these two options as this player’s selection, return it.

Note: we cannot start from te outside to the inner(last point), but only from a single point expands to the whole list.
*/
class WinnerPredictor {
    public boolean PredictTheWinner(int[] nums) {
        return helper(nums, 0, nums.length-1, new Integer[nums.length][nums.length]) >= 0;
    }
    
    private int helper(int[] nums, int s, int e, Integer[][] dp) {
        if (dp[s][e] == null) {
            dp[s][e] = s==e ? nums[s] : Math.max(nums[s] - helper(nums, s+1, e, dp), nums[e] - helper(nums, s, e-1, dp));
        }
        return dp[s][e];
    }
}
