package online.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hey on 5/12/15
 */

/*

https://leetcode.com/problems/pascals-triangle/

Given numRows, generate the first numRows of Pascal's triangle.

For example, given numRows = 5,
Return

[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]

Subscribe to see which companies asked this question

*/

public class PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> pascalTriangle = new ArrayList<>();
        for (int i = 0; i < numRows; ++i) {
            pascalTriangle.add(getRow(i));
        }
        return pascalTriangle;
    }

    private List<Integer> getRow(int i) {
        List<Integer> row = new ArrayList<>();
        int cur = 1;
        row.add(cur);
        for (int j = 1; j <= i; ++j) {
            cur = (int) ((long) cur * (long) (i + 1 - j) / (long) j);
            row.add(cur);
        }
        return row;
    }
}
