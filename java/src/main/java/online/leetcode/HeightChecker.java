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

public class HeightChecker {
    static class Solution {
        public int heightChecker(int[] heights) {
            if (heights == null || heights.length == 0) {
                return 0;
            } else {
                int max = getMax(heights);

                int[] freq = new int[max + 1];

                for (int h : heights) {
                    freq[h]++;
                }

                int curr = 1;
                int count = 0;
                for (int h : heights) {
                    while (freq[curr] == 0) {
                        curr++;
                    }
                    if (h != curr) {
                        count++;
                    }
                    freq[curr]--;
                }

                return count;
            }
        }

        private int getMax(int[] arr) {
            int max = arr[0];
            for (int a : arr) {
                max = Math.max(max, a);
            }
            return max;
        }
    }
}
