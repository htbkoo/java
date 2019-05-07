package online.leetcode;

/*

https://leetcode.com/problems/sort-array-by-parity-ii/

Given an array A of non-negative integers, half of the integers in A are odd, and half of the integers are even.

Sort the array so that whenever A[i] is odd, i is odd; and whenever A[i] is even, i is even.

You may return any answer array that satisfies this condition.



Example 1:

Input: [4,2,5,7]
Output: [4,5,2,7]
Explanation: [4,7,2,5], [2,5,4,7], [2,7,4,5] would also have been accepted.



Note:

    2 <= A.length <= 20000
    A.length % 2 == 0
    0 <= A[i] <= 1000

*/

public class SortArrayByParityII {
    static class Solution {
        public int[] sortArrayByParityII(int[] A) {
            if (A == null || A.length < 2) {
                return A;
            } else {
                int even = 0, odd = 1;
                while (even < A.length && odd < A.length) {
                    if (isOdd(A[even]) && isEven(A[odd])) {
                        // swap
                        int temp = A[even];
                        A[even] = A[odd];
                        A[odd] = temp;
                    }

                    if (isEven(A[even])) {
                        even += 2;
                    }
                    if (isOdd(A[odd])) {
                        odd += 2;
                    }
                }
                return A;
            }
        }

        private boolean isOdd(int n) {
            return n % 2 != 0;
        }

        private boolean isEven(int n) {
            return n % 2 == 0;
        }
    }
}
