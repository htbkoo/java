package online.leetcode;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Hey on 13/10/15
 */

/*

https://leetcode.com/problems/triangle/

Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

For example, given the following triangle

[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]

The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

Note:
Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.

Subscribe to see which companies asked this question

*/

public class Triangle {
//    6ms
    public int minimumTotal(List<List<Integer>> triangle) {
        if ((triangle == null) || (triangle.isEmpty())) {
            return 0;
        }

        final int length = triangle.size();
        final int sums[][] = new int[2][];
        sums[0] = new int[length + 2];
        Arrays.fill(sums[0], Integer.MAX_VALUE);
        sums[1] = new int[length + 2];
        Arrays.fill(sums[1], Integer.MAX_VALUE);

        int currentRow = 0;
        sums[currentRow][1] = triangle.get(0).get(0);
        for (List<Integer> row : triangle.subList(1, triangle.size())) {
            int index = 0;
            currentRow = 1 - currentRow;
            for (Integer num : row) {
                ++index;
                final int prevRow = 1 - currentRow;
                sums[currentRow][index] = num + Math.min(sums[prevRow][index], sums[prevRow][index - 1]);
            }
        }

        int min = Integer.MAX_VALUE;
        for (int sum : sums[currentRow]) {
            min = Math.min(sum, min);
        }
        return min;
    }
}
