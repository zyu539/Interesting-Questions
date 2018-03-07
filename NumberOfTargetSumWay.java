/**
You are given a list of non-negative integers, a1, a2, ..., an, and a target, S. Now you have 2 symbols + and -. For each integer, you should choose one from + and - as its new symbol.

Find out how many ways to assign symbols to make sum of integers equal to target S.

Example 1:
Input: nums is [1, 1, 1, 1, 1], S is 3. 
Output: 5
Explanation: 

-1+1+1+1+1 = 3
+1-1+1+1+1 = 3
+1+1-1+1+1 = 3
+1+1+1-1+1 = 3
+1+1+1+1-1 = 3

There are 5 ways to assign symbols to make the sum of nums be target 3.



Answer: Use DP to find the answer. When trying to solve this kind of problem where directly sovle may take exponential
time complexity, we can try to use DP to record pass states and reduce time needed
*/
class NumberOfTargetSumWay {
    public int findTargetSumWays(int[] nums, int S) {
        int sum = IntStream.of(nums).sum();
        if (sum < S) return 0;
        int[][] dp = new int[nums.length][2*sum+1];
        dp[0][sum+nums[0]] += 1;
        dp[0][sum-nums[0]] += 1;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j <= 2*sum; j++) {
                if (j + nums[i] <= 2*sum) {
                    dp[i][j] += dp[i-1][j + nums[i]];
                }
                if (j - nums[i] >= 0) {
                    dp[i][j] += dp[i-1][j - nums[i]];
                }
            }
        }
        
        // for (int[] tmp : dp) {
        //     for (int i : tmp) {
        //         System.out.print(i + " ");
        //     }
        //     System.out.println();
        // }
        return dp[nums.length-1][sum + S];
    }
}
