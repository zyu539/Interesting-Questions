/**
A sequence X_1, X_2, ..., X_n is fibonacci-like if:

n >= 3
X_i + X_{i+1} = X_{i+2} for all i + 2 <= n
Given a strictly increasing array A of positive integers forming a sequence, find the length of the longest fibonacci-like subsequence of A.  If one does not exist, return 0.

(Recall that a subsequence is derived from another sequence A by deleting any number of elements (including none) from A, without changing the order of the remaining elements.  For example, [3, 5, 8] is a subsequence of [3, 4, 5, 6, 7, 8].)

 

Example 1:

Input: [1,2,3,4,5,6,7,8]
Output: 5
Explanation:
The longest subsequence that is fibonacci-like: [1,2,3,5,8].
Example 2:

Input: [1,3,7,11,12,14,18]
Output: 3
Explanation:
The longest subsequence that is fibonacci-like:
[1,11,12], [3,11,14] or [7,11,18].
 

Note:

3 <= A.length <= 1000
1 <= A[0] < A[1] < ... < A[A.length - 1] <= 10^9




Hint: Use 2D-DP where i, j means the position of the 2 last element of the longest subseq. The elements in DP array should always
represent the solutions of the problem uniquely and completely with less space. In this case, the last 2 element of Fib array can
always determine the next element and is easy to calculate.

Link: https://leetcode.com/problems/length-of-longest-fibonacci-subsequence/
*/
class Solution {
    public int lenLongestFibSubseq(int[] A) {
        int n = A.length;
        int[][] dp = new int[n][n];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(A[i], i);
            for (int j = i + 1; j < n; j++) {
                dp[i][j] = 2;
            }
        }
        
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i-1; j >= 0; j--) {
                int prev = A[i] - A[j];
                if (prev > A[j]) break;
                if (map.containsKey(prev)) {
                    //System.out.println(A[j] + "  " + A[i] + "  " + dp[j][i]);
                    dp[j][i] = Math.max(dp[map.get(prev)][j] + 1, dp[j][i]);
                    max = Math.max(dp[j][i], max);
                }
            }
        }
        
        return max;
    }
}
