package online.leetcode;

/*

https://leetcode.com/problems/house-robber-iii/

The thief has found himself a new place for his thievery again. There is only one entrance to this area, called the "root." Besides the root, each house has one and only one parent house. After a tour, the smart thief realized that "all houses in this place forms a binary tree". It will automatically contact the police if two directly-linked houses were broken into on the same night.

Determine the maximum amount of money the thief can rob tonight without alerting the police.

Example 1:

Input: [3,2,3,null,3,null,1]

     3
    / \
   2   3
    \   \
     3   1

Output: 7
Explanation: Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.

Example 2:

Input: [3,4,5,1,3,null,1]

     3
    / \
   4   5
  / \   \
 1   3   1

Output: 9
Explanation: Maximum amount of money the thief can rob = 4 + 5 = 9.

*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
public class UniquePathsII {
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
