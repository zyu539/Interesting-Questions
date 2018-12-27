/**
Given an array A of integers, a ramp is a tuple (i, j) for which i < j and A[i] <= A[j].  The width of such a ramp is j - i.

Find the maximum width of a ramp in A.  If one doesn't exist, return 0.

 

Example 1:

Input: [6,0,8,2,1,5]
Output: 4
Explanation: 
The maximum width ramp is achieved at (i, j) = (1, 5): A[1] = 0 and A[5] = 5.
Example 2:

Input: [9,8,1,0,1,9,4,0,4,1]
Output: 7
Explanation: 
The maximum width ramp is achieved at (i, j) = (2, 9): A[2] = 1 and A[9] = 1.
 

Note:

2 <= A.length <= 50000
0 <= A[i] <= 50000


Hint: There is a variant 2-point solution which takes only O(n) time

Link: https://leetcode.com/problems/maximum-width-ramp/discuss/208348/JavaC%2B%2BPython-O(N)-Using-Stack
*/
class MaxWidthRamp {
  public int maxWidthRamp(int[] A) {
      Stack<Integer> s = new Stack<>();
      int res = 0, n = A.length;
      for (int i = 0; i < n; ++i)
          if (s.empty() || A[s.peek()] > A[i])
              s.add(i);
      for (int i = n - 1; i > res; --i)
          while (!s.empty() && A[s.peek()] <= A[i])
              res = Math.max(res, i - s.pop());
      return res;
  }
}
