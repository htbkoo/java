package online.leetcode;

/*

https://leetcode.com/problems/valid-mountain-array/

Given an array A of integers, return true if and only if it is a valid mountain array.

Recall that A is a mountain array if and only if:

    A.length >= 3
    There exists some i with 0 < i < A.length - 1 such that:
        A[0] < A[1] < ... A[i-1] < A[i]
        A[i] > A[i+1] > ... > A[B.length - 1]



Example 1:

Input: [2,1]
Output: false

Example 2:

Input: [3,5,5]
Output: false

Example 3:

Input: [0,3,2,1]
Output: true



Note:

    0 <= A.length <= 10000
    0 <= A[i] <= 10000

*/

public class ValidMountainArray_ugly {
    static class Solution {
        public boolean validMountainArray(int[] A) {
            int length = A.length;
            if (length >= 3) {
                if (A[0] >= A[1]) {
                    return false;
                }
                if (A[length - 2] <= A[length - 1]) {
                    return false;
                }
                // we definitely have a peak after the above check

                boolean isPeaked = false;
                for (int i = 2; i < length - 1; ++i) {
                    if (A[i] == A[i - 1]) {
                        return false;
                    } else {
                        if (!isPeaked) {
                            if (A[i] < A[i - 1]) {
                                isPeaked = true;
                            }
                        } else {
                            if (A[i] > A[i - 1]) {
                                return false;
                            }
                        }
                    }
                }
                return true;
            } else {
                return false;
            }
        }
    }
}
