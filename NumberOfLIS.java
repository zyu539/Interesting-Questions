/**
Given an unsorted array of integers, find the number of longest increasing subsequence.

Example 1:
Input: [1,3,5,4,7]
Output: 2
Explanation: The two longest increasing subsequence are [1, 3, 4, 7] and [1, 3, 5, 7].
Example 2:
Input: [2,2,2,2,2]
Output: 5
Explanation: The length of longest continuous increasing subsequence is 1, and there are 5 subsequences' length is 1, so output 5.
Note: Length of the given array will be not exceed 2000 and the answer is guaranteed to be fit in 32-bit signed int.



Answer: use the traditional O(n^2) DP method, the only difference is add a new dp array to store the number of LIS end at
index i, now dpLen[i] is the max length of LIS end at i and dpCount[1] is the number of LIS end at i. Now we find that the
number LIS at index i is the sum of all counts of LIS end at j ,where j < i and LIS[j] + 1 = LIS[i]
*/
class Solution {
    public int findNumberOfLIS(int[] nums) {
        if (nums.length < 2) return nums.length;
        int[] dpLen = new int[nums.length];
        int[] dpCount = new int[nums.length];
        int maxL = 1;
        dpLen[0] = 1;
        dpCount[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            int currLen = 1;
            int currCount = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (currLen < dpLen[j] + 1) {
                        currLen = dpLen[j] + 1;
                        currCount = dpCount[j];
                    } else if (currLen == dpLen[j] + 1) {
                        currCount += dpCount[j];
                    }
                }
            }
            dpLen[i] = currLen;
            dpCount[i] = currCount;
            if (currLen > maxL) maxL = currLen;
        }
        
        int res = 0;
        for (int i = 0; i < dpLen.length; i++) {
            if (dpLen[i] == maxL) {
                res += dpCount[i];
            }
        }
        return res;
    }
}
