package online.leetcode;

/*

https://leetcode.com/problems/squares-of-a-sorted-array/

Given an array of integers A sorted in non-decreasing order, return an array of the squares of each number, also in sorted non-decreasing order.



Example 1:

Input: [-4,-1,0,3,10]
Output: [0,1,9,16,100]

Example 2:

Input: [-7,-3,2,3,11]
Output: [4,9,9,49,121]



Note:

    1 <= A.length <= 10000
    -10000 <= A[i] <= 10000
    A is sorted in non-decreasing order.

*/

public class SquaresOfASortedArray {
    static class Solution {
        public int[] sortedSquares(int[] A) {
            int length = A.length;
            int[] answers = new int[length];
            int pos = length-1, lo = 0, hi = length -1;

            while (lo<=hi){
                int sq_lo = A[lo]*A[lo];
                int sq_hi = A[hi]*A[hi];
                if (sq_lo>sq_hi){
                    answers[pos]=sq_lo;
                    lo++;
                    pos--;
                }else{
                    answers[pos]=sq_hi;
                    hi--;
                    pos--;
                }
            }

            return answers;
        }
    }
}
