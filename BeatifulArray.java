/**
For some fixed N, an array A is beautiful if it is a permutation of the integers 1, 2, ..., N, such that:

For every i < j, there is no k with i < k < j such that A[k] * 2 = A[i] + A[j].

Given N, return any beautiful array A.  (It is guaranteed that one exists.)

 

Example 1:

Input: 4
Output: [2,1,4,3]
Example 2:

Input: 5
Output: [3,1,2,5,4]
 

Note:

1 <= N <= 1000


Hint: Divide and Conquer. If an beatiful array of N size exist, then the beatiful array of 2 * N size can be formed be concatenate
2 * N - 1 array and 2 * N array (both of which should be beatiful).

Link: https://leetcode.com/problems/beautiful-array/
      http://www.noteanddata.com/leetcode-932-Beautiful-Array-java-solution-note.html
*/
class Solution {
    public int[] beautifulArray(int N) {
        List<Integer> list = new ArrayList<>();
        list.add(1);

        while(list.size() < N) {
            List<Integer> next = new ArrayList<>();
            for(int v: list) {
                if(2*v-1 <= N) {
                    next.add(2 * v -1);    
                }                
            }
            for(int v: list) {
                if(2*v <= N) {
                    next.add(2 * v);    
                }                
            }
            list = next;
        }
        int[] ret = new int[N];
        for(int i = 0; i < N; ++i) {
            ret[i] = list.get(i);
        }
        return ret;
    }
}
