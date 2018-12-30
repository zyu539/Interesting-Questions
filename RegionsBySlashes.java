/**
n a N x N grid composed of 1 x 1 squares, each 1 x 1 square consists of a /, \, or blank space.  These characters divide the square into contiguous regions.

(Note that backslash characters are escaped, so a \ is represented as "\\".)

Return the number of regions.

 

Example 1:

Input:
[
  " /",
  "/ "
]
Output: 2
Explanation: The 2x2 grid is as follows:

Example 2:

Input:
[
  " /",
  "  "
]
Output: 1
Explanation: The 2x2 grid is as follows:

Example 3:

Input:
[
  "\\/",
  "/\\"
]
Output: 4
Explanation: (Recall that because \ characters are escaped, "\\/" refers to \/, and "/\\" refers to /\.)
The 2x2 grid is as follows:

Example 4:

Input:
[
  "/\\",
  "\\/"
]
Output: 5
Explanation: (Recall that because \ characters are escaped, "/\\" refers to /\, and "\\/" refers to \/.)
The 2x2 grid is as follows:

Example 5:

Input:
[
  "//",
  "/ "
]
Output: 3
Explanation: The 2x2 grid is as follows:

 

Note:

1 <= grid.length == grid[0].length <= 30
grid[i][j] is either '/', '\', or ' '.



Hint: The problem is the same as 'finding how many islands in the sea' We could represent the unit square as 3*3 matrix and
slash lines as barriers ('sea'). There are 2 different solutions using union-find and DFS separately, both are great and beautiful.


Link: https://leetcode.com/problems/regions-cut-by-slashes/discuss/205680/JavaC%2B%2BPython-Split-4-parts-and-Union-Find
      https://leetcode.com/problems/regions-cut-by-slashes/discuss/205674/C%2B%2B-with-picture-DFS-on-upscaled-grid
      
Besides, there is also a solution using Euler Formula which is interesting: https://leetcode.com/problems/regions-cut-by-slashes/discuss/205738/Using-Euler's-Formula-(V-E-%2B-F-2)
*/
class RegionsBySlashes {
    public int regionsBySlashes(String[] grid) {
        int[][] g = new int[grid.length * 3][grid.length * 3];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length(); j++) {
                if (grid[i].charAt(j) == '\\') {
                    for (int k = 0; k < 3; k++) {
                        g[3*i + k][3*j + k] = 1;
                    }
                } else if (grid[i].charAt(j) == '/') {
                    for (int k = 0; k < 3; k++) {
                        g[3*i + k][3*j + 2 - k] = 1;
                    }
                }
            }
        }
        
        int count = 0;
        for (int i = 0; i < g.length; i++) {
            for (int j = 0; j < g.length; j++) {
                if (g[i][j] == 0) {
                    dfs(g, i, j);
                    count++;
                }
            }
        }
        return count;
    }
    
    private void dfs(int[][] g, int x, int y) {
        if (g[x][y] < 0) return;
        g[x][y] = -1;
        int[][] dir = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for (int i = 0; i < 4; i++) {
            int x1 = x + dir[i][0], y1 = y + dir[i][1];
            if (x1 >= 0 && x1 < g.length && y1 >= 0 && y1 < g.length && g[x1][y1] == 0) {
                dfs(g, x1, y1);
            }
        }
    }
}
