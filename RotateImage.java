/**
You are given an n x n 2D matrix representing an image.

Rotate the image by 90 degrees (clockwise).

Note:
You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.

Example 1:

Given input matrix = 
[
  [1,2,3],
  [4,5,6],
  [7,8,9]
],

rotate the input matrix in-place such that it becomes:
[
  [7,4,1],
  [8,5,2],
  [9,6,3]
]


Answer: Quite interesting method, first reverse the top and down side of the image, then reverse it according
to the diagonal. (For anti-clockwise, first reverse the left and right side, then reverse it according
to the diagonal)
 1 2 3     7 8 9     7 4 1
 4 5 6  => 4 5 6  => 8 5 2
 7 8 9     1 2 3     9 6 3
 
 1 2 3     3 2 1     3 6 9
 4 5 6  => 6 5 4  => 2 5 8
 7 8 9     9 8 7     1 4 7
*/
class Solution {
    public void rotate(int[][] matrix) {
        for (int i = 0; i < matrix.length / 2; i++) {
            int[] tmp = matrix[i];
            matrix[i] = matrix[matrix.length-i-1];
            matrix[matrix.length-i-1] = tmp;
        }
        
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i + 1; j < matrix[0].length; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
    }
    
}
