package online.leetcode;

/*

https://leetcode.com/problems/find-common-characters/

Given an array A of strings made only from lowercase letters, return a list of all characters that show up in all strings within the list (including duplicates).  For example, if a character occurs 3 times in all strings but not 4 times, you need to include that character three times in the final answer.

You may return the answer in any order.




Input: ["bella","label","roller"]
Output: ["e","l","l"]

Example 2:

Input: ["cool","lock","cook"]
Output: ["c","o"]



Note:

    1 <= A.length <= 100
    1 <= A[i].length <= 100
    A[i][j] is a lowercase letter

*/

public class SmallestRangeI {
    static class Solution {
        public int smallestRangeI(int[] A, int K) {
            if (A.length == 0) {
                return 0;
            } else {
                int min = A[0], max = A[0];
                for (int a : A) {
                    min = Math.min(a, min);
                    max = Math.max(a, max);
                }
                return Math.max(0, (max - min) - 2 * K);
            }
        }
    }
}
