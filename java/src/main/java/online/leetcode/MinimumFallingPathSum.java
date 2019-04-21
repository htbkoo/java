package online.leetcode;

/*

https://leetcode.com/problems/minimum-falling-path-sum/

Given a square array of integers A, we want the minimum sum of a falling path through A.

A falling path starts at any element in the first row, and chooses one element from each row.  The next row's choice must be in a column that is different from the previous row's column by at most one.



Example 1:

Input: [[1,2,3],[4,5,6],[7,8,9]]
Output: 12
Explanation:
The possible falling paths are:

    [1,4,7], [1,4,8], [1,5,7], [1,5,8], [1,5,9]
    [2,4,7], [2,4,8], [2,5,7], [2,5,8], [2,5,9], [2,6,8], [2,6,9]
    [3,5,7], [3,5,8], [3,5,9], [3,6,8], [3,6,9]

The falling path with the smallest sum is [1,4,7], so the answer is 12.



Note:

    1 <= A.length == A[0].length <= 100
    -100 <= A[i][j] <= 100

*/

public class MinimumFallingPathSum {
    static class Solution {
        public int minFallingPathSum(int[][] A) {
            int height = A.length;
            if (height == 0) {
                return 0;
            } else {
                int width = A[0].length;
                for (int i = 1; i < height; ++i) {
                    for (int j = 0; j < width; ++j) {
                        int best = A[i - 1][j];
                        if (j > 0) {
                            best = Math.min(best, A[i - 1][j - 1]);
                        }
                        if (j < width - 1) {
                            best = Math.min(best, A[i - 1][j + 1]);
                        }
                        A[i][j] = A[i][j] + best;
                    }
                }
                int min = A[height - 1][0];
                for (int j = 1; j < width; ++j) {
                    min = Math.min(min, A[height - 1][j]);
                }
                return min;
            }
        }
    }
}
