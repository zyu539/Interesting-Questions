/**
Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.

Follow up:
Did you use extra space?
A straight forward solution using O(mn) space is probably a bad idea.
A simple improvement uses O(m + n) space, but still not the best solution.
Could you devise a constant space solution?

Link: https://leetcode.com/problems/set-matrix-zeroes/description/


Answer: the O(1) space method is just use the matri itself to store state of rows and cols. we store the
state of rows and cols int the first element of that row/col, since matrix[0][0] cannot represent both row
and col state, we use an additional variable col0 to represent the state of first col. Note when modifying
the matrix according to state, we start from right bottom side so that the modify will not influence states
*/

class Solution {
    public void setZeroes(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return;
        int m = matrix.length;
        int n = matrix[0].length;
        int col0 = matrix[0][0];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    if (j == 0) {
                        col0 = 0;
                    } else {
                        matrix[0][j] = 0;
                    }
                    matrix[i][0] = 0;
                }
            }
        }
        for (int i = m-1; i >= 0; i--) {
            for (int j = n-1; j >= 0; j--) {
                if (j == 0 && col0 == 0) matrix[i][j] = 0;
                if (j != 0 && (matrix[i][0] == 0 || matrix[0][j] == 0)) matrix[i][j] = 0;
            }
            System.out.println();
        }
    }
}
