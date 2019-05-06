package online.leetcode;

/*

https://leetcode.com/problems/intersection-of-two-arrays-ii/

Given two arrays, write a function to compute their intersection.

Example 1:

Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2,2]

Example 2:

Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [4,9]

Note:

    Each element in the result should appear as many times as it shows in both arrays.
    The result can be in any order.

Follow up:

    What if the given array is already sorted? How would you optimize your algorithm?
    What if nums1's size is small compared to nums2's size? Which algorithm is better?
    What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?

*/

import java.util.Arrays;

public class IntersectionOfTwoArraysII {
    static class Solution {
        public int[] intersect(int[] nums1, int[] nums2) {
            Arrays.sort(nums1);
            Arrays.sort(nums2);

            int ptr1 = 0, ptr2 = 0, pos = 0;

            while (ptr1 < nums1.length && ptr2 < nums2.length) {
                if (nums1[ptr1] < nums2[ptr2]) {
                    ptr1++;
                } else if (nums1[ptr1] > nums2[ptr2]) {
                    ptr2++;
                } else {
                    nums2[pos] = nums2[ptr2];
                    ptr1++;
                    ptr2++;
                    pos++;
                }
            }

            return Arrays.copyOf(nums2, pos);
        }
    }
}
