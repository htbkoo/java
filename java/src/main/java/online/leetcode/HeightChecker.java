package online.leetcode;

/*

https://leetcode.com/problems/height-checker/

Students are asked to stand in non-decreasing order of heights for an annual photo.

Return the minimum number of students not standing in the right positions.  (This is the number of students that must move in order for all students to be standing in non-decreasing order of height.)



Example 1:

Input: [1,1,4,2,1,3]
Output: 3
Explanation:
Students with heights 4, 3 and the last 1 are not standing in the right positions.



Note:

    1 <= heights.length <= 100
    1 <= heights[i] <= 100

*/

import java.util.Arrays;

public class HeightChecker {
    static class Solution {
        public int heightChecker(int[] heights) {
            if (heights == null || heights.length == 0) {
                return 0;
            } else {
                int[] sortedHeights = sortedCopyOf(heights);
                int count = 0;
                for (int i = 0, length = heights.length; i < length; ++i) {
                    if (heights[i] != sortedHeights[i]) {
                        count++;
                    }
                }

                return count;
            }
        }

        private int[] sortedCopyOf(int[] arr) {
            int length = arr.length;
            int[] newArr = new int[length];
            System.arraycopy(arr, 0, newArr, 0, length);
            Arrays.sort(newArr);
            return newArr;
        }
    }
}
