package online.leetcode;

/*

https://leetcode.com/problems/sort-array-by-parity/

Given an array A of non-negative integers, return an array consisting of all the even elements of A, followed by all the odd elements of A.

You may return any answer array that satisfies this condition.



Example 1:

Input: [3,1,2,4]
Output: [2,4,3,1]
The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.



Note:

    1 <= A.length <= 5000
    0 <= A[i] <= 5000

*/

import java.util.Arrays;

public class SortArrayByParity {
    static class Solution {
        public int[] sortArrayByParity_sort_stream(int[] A) {
            return Arrays.stream(A)
                    .boxed()
                    .sorted((a, b) -> Integer.compare(a % 2, b % 2))
                    .mapToInt(i -> i)
                    .toArray();
        }

        // two_passes approach
        public int[] sortArrayByParity(int[] A) {
            int length = A.length;
            int[] sorted = new int[length];

            int current = 0;

            // populate even
            for (int a : A) {
                if (a % 2 == 0) {
                    sorted[current] = a;
                    current++;
                }
            }

            // populate odd
            for (int a : A) {
                if (a % 2 != 0) {
                    sorted[current] = a;
                    current++;
                }
            }

            return sorted;
        }
    }
}
