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
import java.util.Comparator;

public class SortArrayByParity {
    static class Solution {
        // sort_array_with_comparator approach
        public int[] sortArrayByParity_sort_stream(int[] A) {
            return Arrays.stream(A)
                    .boxed()
                    .sorted(Comparator.comparingInt(a -> a % 2))
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

        // quick_sort approach
        public int[] sortArrayByParity_quick_sort(int[] A) {
            int lo=0, hi=A.length-1;

            // similar to quick sort
            while (lo<=hi){
                if (isEven(A[lo]) && isOdd(A[hi]) ){
                    lo++;
                    hi--;
                }else if (isOdd(A[lo]) && isEven(A[hi])){
                    // swap
                    int temp = A[lo];
                    A[lo] = A[hi];
                    A[hi] = temp;

                    lo++;
                    hi--;
                }else {
                    if (isEven(A[lo]) && isEven(A[hi])){
                        lo++;
                    }else if (isOdd(A[lo]) && isOdd(A[hi])){
                        hi--;
                    }
                }
            }

            return A;
        }

        private boolean isEven(int n){
            return n%2==0;
        }

        private boolean isOdd(int n) {
            return n % 2 != 0;
        }
    }
}
