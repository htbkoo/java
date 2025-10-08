package online.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hey on 08/Oct/2025
 */

/*
54. Spiral Matrix
https://leetcode.com/classic/problems/spiral-matrix/description/

Given an m x n matrix, return all elements of the matrix in spiral order.



Example 1:

Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [1,2,3,6,9,8,7,4,5]

Example 2:

Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]



Constraints:

    m == matrix.length
    n == matrix[i].length
    1 <= m, n <= 10
    -100 <= matrix[i][j] <= 100

*/

class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        var HEIGHT = matrix.length; // TODO: validate input (e.g. rectangular shape, non-null) and handle
        var WIDTH = matrix[0].length;

        var top = 0;
        var bottom = HEIGHT - 1;
        var left = 0;
        var right = WIDTH - 1;

        List<Integer> answer = new ArrayList<>();
        while (top <= bottom && left <= right) {
            // top row
            for (var x = left; x <= right; ++x) {
                answer.add(matrix[top][x]);
            }

            // right column
            for (var y = top + 1; y <= bottom; ++y) {
                answer.add(matrix[y][right]);
            }

            // bottom row
            if (bottom > top) {
                for (var x = right - 1; x >= left; --x) {
                    answer.add(matrix[bottom][x]);
                }
            }

            // left column
            if (left < right) {
                for (var y = bottom - 1; y >= top + 1; --y) {
                    answer.add(matrix[y][left]);
                }
            }

            top++;
            bottom--;
            left++;
            right--;
        }

        return answer;
    }
}
