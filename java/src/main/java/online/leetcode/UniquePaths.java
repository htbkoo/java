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

    public class Simple2DArray {
        private final int[][] matrix;

        public Simple2DArray(int m, int n) {
            //noinspection unchecked
            this.matrix = new int[m + 1][n + 1];
        }

        public void put(int i, int j, int element) {
            this.matrix[i][j] = element;
        }

        public int get(int i, int j) {
            return this.matrix[i][j];
        }
    }


    public int uniquePaths(int m, int n) {
        Simple2DArray dpTable;

        dpTable = new Simple2DArray(m, n);

        for (int i = 1; i <= m; i++) {
            dpTable.put(i, 1, 1);
        }
        for (int j = 1; j <= n; j++) {
            dpTable.put(1, j, 1);
        }

        for (int i = 2; i <= m; i++) {
            for (int j = 2; j <= n; j++) {
                dpTable.put(i, j, dpTable.get(i - 1, j) + dpTable.get(i, j - 1));
            }
        }
        return dpTable.get(m, n);
    }
}
