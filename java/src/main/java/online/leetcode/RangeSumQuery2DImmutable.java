package online.leetcode;

/**
 * Created by Hey on 26 Jun 2016
 */
/*

https://leetcode.com/problems/range-sum-query-2d-immutable/

Given a 2D matrix matrix, find the sum of the elements inside the rectangle defined by its upper left corner (row1, col1) and lower right corner (row2, col2).

Range Sum Query 2D
The above rectangle (with the red border) is defined by (row1, col1) = (2, 1) and (row2, col2) = (4, 3), which contains sum = 8.

Example:

Given matrix = [
  [3, 0, 1, 4, 2],
  [5, 6, 3, 2, 1],
  [1, 2, 0, 1, 5],
  [4, 1, 0, 1, 7],
  [1, 0, 3, 0, 5]
]

sumRegion(2, 1, 4, 3) -> 8
sumRegion(1, 1, 2, 2) -> 11
sumRegion(1, 2, 2, 4) -> 12

Note:

    You may assume that the matrix does not change.
    There are many calls to sumRegion function.
    You may assume that row1 ≤ row2 and col1 ≤ col2.

Subscribe to see which companies asked this question

*/

//    Required by LeetCode OJ runner
@SuppressWarnings("WeakerAccess")
public class RangeSumQuery2DImmutable {
    public static class NumMatrix {
        private final int[][] cumulativeMatrix;

        public NumMatrix(int[][] matrix) {
            final int height = matrix.length;
            int width;
            if (height > 0) {
                width = matrix[0].length;
            } else {
                width = 0;
            }
            cumulativeMatrix = new int[height + 1][width + 1];
            for (int r = 1; r <= height; ++r) {
                for (int c = 1; c <= width; ++c) {
                    cumulativeMatrix[r][c] = matrix[r - 1][c - 1] - calculate2DSum(r, c, r, c);
                }
            }

        }

        private int calculate2DSum(int row1, int col1, int row2, int col2) {
            return cumulativeMatrix[row2][col2]
                    - cumulativeMatrix[row1 - 1][col2]
                    - cumulativeMatrix[row2][col1 - 1]
                    + cumulativeMatrix[row1 - 1][col1 - 1];
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            return calculate2DSum(row1 + 1, col1 + 1, row2 + 1, col2 + 1);
        }
    }


// Your NumMatrix object will be instantiated and called as such:
// NumMatrix numMatrix = new NumMatrix(matrix);
// numMatrix.sumRegion(0, 1, 2, 3);
// numMatrix.sumRegion(1, 2, 3, 4);

}
