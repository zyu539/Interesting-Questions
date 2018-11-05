/**
Given a n x n matrix where each of the rows and columns are sorted in ascending order, find the kth smallest element in the matrix.

Note that it is the kth smallest element in the sorted order, not the kth distinct element.

Example:

matrix = [
   [ 1,  5,  9],
   [10, 11, 13],
   [12, 13, 15]
],
k = 8,

return 13.
Note: 
You may assume k is always valid, 1 ≤ k ≤ n2.




Hint: Use range based binary search to locate the result.

Link: https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/discuss/85173/Share-my-thoughts-and-Clean-Java-Code
*/
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        if(k==1) return matrix[0][0];
        int n = matrix.length;
        if(k==n*n) return matrix[n-1][n-1];
        int min = matrix[0][0], max = matrix[n-1][n-1];
        while(min < max) {
            int mid = min + (max - min) / 2;
            int count = countLessEqual(matrix, mid);
            System.out.println(count + ":    " + min + "   " + mid + "   " + max);
            if(count < k) {
                min = mid + 1;
            } else {
                max = mid;
            }
        }
        return min;
    }
    
    private int countLessEqual(int[][] matrix, int target) {
        int count = 0;
        int x = matrix.length-1, y = 0;
        while(x>=0 && y<matrix.length) {
            if(matrix[x][y] <= target) {
                y++;
                count += x+1;
            } else {
                x--;
            }
        }
        return count;
    }
}
