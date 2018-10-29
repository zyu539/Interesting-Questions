/**
On a 2 dimensional grid with R rows and C columns, we start at (r0, c0) facing east.

Here, the north-west corner of the grid is at the first row and column, and the south-east corner of the grid is at the last row and column.

Now, we walk in a clockwise spiral shape to visit every position in this grid. 

Whenever we would move outside the boundary of the grid, we continue our walk outside the grid (but may return to the grid boundary later.) 

Eventually, we reach all R * C spaces of the grid.

Return a list of coordinates representing the positions of the grid in the order they were visited.



Hint: the step on each edge follows the rule: 1,1,2,2,3,3...

Answer Link: https://leetcode.com/problems/spiral-matrix-iii/discuss/158970/C++JavaPython-112233-Steps
*/

public class SpiralMatrixIII {
    public int[][] spiralMatrixIII(int R, int C, int r, int c) {
        int[][] res = new int[R * C][2];
        res[0] = new int[] {r, c};
        int x = 0, y = 1, n = 0, i = 0, tmp, j = 1;
        while (j < R * C) {
            r += x; c += y; i++;
            if (0 <= r && r < R && 0 <= c && c < C)
                res[j++] = new int[] {r, c};
            if (i == n / 2 + 1) {
                i = 0; n++; tmp = x; x = y; y = -tmp;
            }
        }
        return res;
    }
}
