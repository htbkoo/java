package online.leetcode;

/*

https://leetcode.com/problems/unique-paths-ii/

A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

Now consider if some obstacles are added to the grids. How many unique paths would there be?

An obstacle and empty space is marked as 1 and 0 respectively in the grid.

Note: m and n will be at most 100.

Example 1:

Input:
[
  [0,0,0],
  [0,1,0],
  [0,0,0]
]
Output: 2
Explanation:
There is one obstacle in the middle of the 3x3 grid above.
There are two ways to reach the bottom-right corner:
1. Right -> Right -> Down -> Down
2. Down -> Down -> Right -> Right

*/

public class UniquePathsII_unclean {
    static class Solution {
        public int uniquePathsWithObstacles(int[][] obstacleGrid) {
            if (obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0) {
                return 0;
            } else {
                int height = obstacleGrid.length, width = obstacleGrid[0].length;
                int[] currentRow;
                int[] nextRow = new int[width];

                nextRow[0] = isBlocked(obstacleGrid, 0, 0) ? 0 : 1;
                for (int j = 1; j < width; ++j) {
                    nextRow[j] = isBlocked(obstacleGrid, 0, j) ? 0 : Math.min(1, nextRow[j - 1]);
                }

                for (int i = 1; i < height; ++i) {
                    currentRow = nextRow;
                    nextRow = new int[width];

                    nextRow[0] = isBlocked(obstacleGrid, i, 0) ? 0 : Math.min(1, currentRow[0]);

                    for (int j = 1; j < width; ++j) {
                        nextRow[j] = isBlocked(obstacleGrid, i, j)
                                ? 0
                                : (nextRow[j - 1] + currentRow[j]);
                    }
                }

                return nextRow[width - 1];
            }
        }

        private boolean isBlocked(int[][] obstacleGrid, int i, int j) {
            return obstacleGrid[i][j] == 1;
        }

    }
}
