package online.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hey on 5/12/15
 */

/*

https://leetcode.com/problems/pascals-triangle-ii/

Given an index k, return the kth row of the Pascal's triangle.

For example, given k = 3,
Return [1,3,3,1].

Note:
Could you optimize your algorithm to use only O(k) extra space?

Subscribe to see which companies asked this question

*/

public class PascalsTriangleII {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<>();
        int cur = 1;
        row.add(cur);
        for (int j = 1; j <= rowIndex; ++j) {
            cur = (int) ((long) cur * (long) (rowIndex + 1 - j) / (long) j);
            row.add(cur);
        }
        return row;
    }
}
