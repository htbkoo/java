package online.leetcode;

/**
 * Created by Hey on 30/1/16
 */

/*

https://leetcode.com/problems/unique-paths/

A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

How many possible unique paths are there?


Above is a 3 x 7 grid. How many possible unique paths are there?

Note: m and n will be at most 100.

Subscribe to see which companies asked this question

*/

public class UniquePaths {
    public int uniquePaths(int m, int n) {
        final int[][] matrix = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            matrix[i][1] = 1;
        }
        for (int j = 1; j <= n; j++) {
            matrix[1][j] = 1;
        }
        for (int i = 2; i <= m; i++) {
            for (int j = 2; j <= n; j++) {
                matrix[i][j] = matrix[i-1][j]+matrix[i][j-1];
            }
        }
        return matrix[m][n];
    }
}
