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

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class SquaresOfASortedArray_slow {
    static class Solution {
        public int[] sortedSquares(int[] A) {
            PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.comparing(Integer::intValue).reversed());
            Arrays.stream(A).forEach(a->heap.add(a*a));

            int n = heap.size();
            int[] answer = new int[n];
            while (!heap.isEmpty()){
                n--;
                answer[n] = heap.poll();
            }

            return answer;
        }
    }
}
